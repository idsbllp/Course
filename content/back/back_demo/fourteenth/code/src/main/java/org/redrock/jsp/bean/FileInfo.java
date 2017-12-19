package org.redrock.jsp.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 有空了查下pojo
 * 有人在这里用了序列化 你知道那是干什么的吗？
 */
public class FileInfo {
    //使用了lombok的注解工具 不需要写烦人的getter 跟 setter 很清真
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private boolean isExecute;

    @Getter @Setter
    private long lastModified;

    @Getter @Setter
    private boolean isDirectory;

    @Getter @Setter
    private int pid;

    @Getter @Setter
    private List<FileInfo> childFiles;
}
