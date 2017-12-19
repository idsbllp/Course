package org.redrock.jsp.dao.impl;

import org.redrock.jsp.bean.FileInfo;
import org.redrock.jsp.dao.FileDao;
import org.redrock.jsp.util.DatabaseUtil;
import org.redrock.jsp.util.PropertiesUtil;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 文件信息数据访问层 实现
 */
public class FileDaoImpl implements FileDao {

    //自增id，相当于一个int吧，但是因为i++的缘故，这个存在线程安全的问题，看不懂跳过
    static AtomicInteger count;

    Connection connection = DatabaseUtil.getConnection();

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Override
    public List<FileInfo> getFileInfoByName(String name) {
        List<FileInfo> files = null;
        try {
            files = new ArrayList<>();
            String sql = "select * from file where name like '%" + name + "%'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.setId(resultSet.getInt("id"));
                fileInfo.setPid(resultSet.getInt("pid"));
                fileInfo.setDirectory(resultSet.getInt("type") == 1);
                fileInfo.setLastModified(resultSet.getLong("lastModified"));
                fileInfo.setName(resultSet.getString("name"));
                fileInfo.setExecute(resultSet.getBoolean("isExecute"));
                files.add(fileInfo);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return files;
    }

    /**
     * 通过id精确查询
     * @param id
     * @return
     */
    @Override
    public FileInfo getFileInfoById(int id) {
        FileInfo fileInfo = null;
        try {
            String sql = "select * from file where id = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                fileInfo = new FileInfo();
                fileInfo.setId(resultSet.getInt("id"));
                fileInfo.setPid(resultSet.getInt("pid"));
                fileInfo.setDirectory(resultSet.getInt("type") == 1);
                fileInfo.setLastModified(resultSet.getLong("lastModified"));
                fileInfo.setName(resultSet.getString("name"));
                fileInfo.setExecute(resultSet.getBoolean("isExecute"));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fileInfo;
    }

    /**
     * 存储文件信息
     * 实际上就是通过一个根节点去递归遍历其下所有子节点
     * 放到前端去看就可以用来遍历后端传过去的文件信息树 或者是 目录树
     */
    @Override
    public void storeFileInfo() {
        try {
            //每次调用count必须清0
            count = new AtomicInteger(0);
            String rootPath = PropertiesUtil.getProperty("root.path");
            File file = new File(rootPath);
            Statement statement = connection.createStatement();
            statement.execute("delete from file");
            storeFileInfo(file, statement, 0);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取所有文件信息
     * @return
     */
    @Override
    public List<FileInfo> getAllFiles() {
        List<FileInfo> files = null;
        try {
            files = new ArrayList<>();
            String sql = "select * from file";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.setId(resultSet.getInt("id"));
                fileInfo.setPid(resultSet.getInt("pid"));
                fileInfo.setDirectory(resultSet.getInt("type") == 1);
                fileInfo.setLastModified(resultSet.getLong("lastModified"));
                fileInfo.setName(resultSet.getString("name"));
                fileInfo.setExecute(resultSet.getBoolean("isExecute"));
                files.add(fileInfo);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return files;
    }

    /**
     * 递归存储文件信息
     * @param dir
     * @param statement
     * @param pid
     * @throws SQLException
     */
    private void storeFileInfo(File dir, Statement statement, int pid) throws SQLException {
        File[] files = dir.listFiles();
        if (files != null && files.length != 0) {
            for (File item : files) {
                if (item.getAbsolutePath().equals("/Users/jiangtianxing/Library")) continue;
                int id = count.addAndGet(1);
                //name中可能存在单引号，将单引号转移，此处最好通过字符串转义 与 使用 preparedStatement 防sql注入
                String name = item.getName().replace("'","&apos;");
                long lastModified = item.lastModified();
                int type = item.isDirectory() ? 1 : 0;
                boolean isExecute = item.canExecute() ;
                StringBuilder builder = new StringBuilder();
                builder.append("insert into file(id, name, isExecute, type, lastModified, pid) values(")
                        .append(id).append(", '")
                        .append(name).append("', '")
                        .append(isExecute).append("', '")
                        .append(type).append("', ")
                        .append(lastModified).append(", ")
                        .append(pid).append(")");
                statement.execute(builder.toString());
                if (item.isDirectory()) storeFileInfo(item, statement, id);
            }
        }
    }
}
