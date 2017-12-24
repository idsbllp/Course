package org.redrock.jsp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static Connection connection;

    /**
     * 获取单例连接
     * 数据库相关操作课上讲的很水，建议疯狂java上面的jdbc好好看，还有sql基础好好补一补
     * https://stu.redrock.team/content/back/back_demo/tree/sql.html
     * @return
     */
    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseUtil.class) {
                if (connection == null) {
                    try {
                        String url = PropertiesUtil.getProperty("mysql.url");
                        String user = PropertiesUtil.getProperty("mysql.user");
                        String password = PropertiesUtil.getProperty("mysql.password");
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection(url, user, password);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
