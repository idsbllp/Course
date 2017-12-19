package org.redrock.jsp.dao;

import org.redrock.jsp.bean.FileInfo;

import java.util.List;

/**
 * 数据访问层 接口
 * 专注于数据库操作
 */
public interface FileDao {
    //通过文件名获取相同文件名的文件信息
    List<FileInfo> getFileInfoByName(String name);

    FileInfo getFileInfoById(int id);

    void storeFileInfo();

    List<FileInfo> getAllFiles();
}