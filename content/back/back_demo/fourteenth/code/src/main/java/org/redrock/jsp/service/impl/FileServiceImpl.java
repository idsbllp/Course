package org.redrock.jsp.service.impl;

import org.redrock.jsp.bean.FileInfo;
import org.redrock.jsp.dao.FileDao;
import org.redrock.jsp.dao.impl.FileDaoImpl;
import org.redrock.jsp.service.FileService;
import java.util.*;

/**
 * 文件信息业务逻辑层实现
 */
public class FileServiceImpl implements FileService{
    private FileDao fileDao = new FileDaoImpl();

    /**
     * 获取文件名的绝对路径
     * 必须理解为什么在这里是递归获取文件绝对路径，而不是直接将文件绝对路径直接存至数据库中
     * 递归获取是一种实现思想，放在文件目录这种特殊的土壤可以存路径，那万一要实现的功能是留言板怎么办
     * @param name
     * @return
     */
    @Override
    public List<String> getFilePath(String name) {
        //可能查处多条结果
        List<FileInfo> files = fileDao.getFileInfoByName(name);
        List<String> paths = new ArrayList<>();
        for (FileInfo item : files) {
            LinkedList<String> pathInfo = new LinkedList<>();
            getParentFilePath(pathInfo, item);
            StringBuilder builder = new StringBuilder();
            //将文件的父集目录名组成的数组从后向前拼接起来
            for (int i = pathInfo.size() - 1; i > -1; i--) {
                builder.append(pathInfo.get(i)).append("/");
            }
            builder.append(item.getName());
            paths.add(builder.toString());
        }
        return paths;
    }

    /**
     * 将文件信息存入数据库
     */
    @Override
    public void storeFileInfo() {
        fileDao.storeFileInfo();
    }

    /**
     * 这个方法压树思想极其重要，可以联想到留言板、页面多级目录树的实现
     * @return
     */
    @Override
    public FileInfo getRootFileInfo() {
        //创建根结点
        FileInfo root = new FileInfo();
        root.setId(0);
        root.setName("root");
        root.setLastModified(System.currentTimeMillis());
        root.setDirectory(true);
        List<FileInfo> rootFiles = new ArrayList<>();
        //获取所有文件对象
        List<FileInfo> allFiles = fileDao.getAllFiles();
        Map<String, FileInfo> fileMap = new HashMap<>();
        //将文件以 key(id)=>value(FileInfo) 的形式放入map中
        for (FileInfo item : allFiles) {
            //添加根结点下的子文件
            if (item.getPid() == 0) rootFiles.add(item);
            fileMap.put(item.getId() + "", item);
        }
        //通过遍历将 子节点与父节点 连接起来
        for (FileInfo item : allFiles) {
            if (item.getPid() != 0) {
                FileInfo parent = fileMap.get(item.getPid() + "");
                List<FileInfo> childFiles = parent.getChildFiles();
                if (childFiles == null) {
                    childFiles = new ArrayList<>();
                    parent.setChildFiles(childFiles);
                }
                childFiles.add(item);
            }
        }
        root.setChildFiles(rootFiles);
        return root;
    }

    /**
     * 获取父节点的文件名
     * @param pathInfo
     * @param file
     */
    private void getParentFilePath(LinkedList<String> pathInfo, FileInfo file) {
        if (file.getPid() != 0) {
            FileInfo fileInfo = fileDao.getFileInfoById(file.getPid());
            pathInfo.add(fileInfo.getName());
            getParentFilePath(pathInfo, fileInfo);
        }
    }
}