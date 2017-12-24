package org.redrock.jsp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties properties;

    /**
     * 静态初始化块
     * 因为Properties的真正初始化不能通过new Properties()一步完成创建并且加载相关文件信息，所以放到了一个静态初始化块中
     * 以此类推 一般初始化块作用
     * 以及 四种加载类型的加载顺序
     */
    static {
        try {
            properties = new Properties();
            InputStream inputStream = PropertiesUtil.class.getResourceAsStream("/config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取property属性
     * @param name
     * @return
     */
    public static String getProperty(String name) {
        return properties.getProperty(name);
    }
}
