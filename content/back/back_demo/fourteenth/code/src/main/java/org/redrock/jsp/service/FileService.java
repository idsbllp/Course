package org.redrock.jsp.service;

import org.redrock.jsp.bean.FileInfo;

import java.util.List;

/**
 * 业务逻辑层 接口
 * 在查询功能方面来说，完成一个功能不仅仅在于查询数据库获取数据，还在于对查询数据的结构组织
 * 在处理数据方面来说，不仅仅在于对数据库相应的增删改查，还在于进行增删改之前进行的一些过滤检验判断
 * 可能实现这些方法需要多个函数相互调用，但相对与具体实现的接口的类，通过接口可以对外屏蔽掉底层实现，而专注于应该实现的功能
 */
public interface FileService {
    //通过文件名查询文件路径
    List<String> getFilePath(String name);

    //文件信息储存进数据库
    void storeFileInfo();

    //获取文件信息树的根结点
    FileInfo getRootFileInfo();
}