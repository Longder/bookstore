package com.longder.bookstore.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 数据库连接工具类
 */
public class DBUtil {
    /**
     * jdbc连接Url
     */
    private static String url;
    /**
     * jdbc驱动名称
     */
    private static String driverClassName;
    /**
     * 数据库用户名
     */
    private static String username;
    /**
     * 数据库密码
     */
    private static String password;

    /**
     * 静态块，读取properties文件
     */
    static{
        try {
            //properties属性对象
            Properties properties = new Properties();
            //获取一个从文件的输入流
            InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            //读取文件
            properties.load(is);
            //赋值
            url = properties.getProperty("jdbc.url");
            driverClassName = properties.getProperty("jdbc.driver");
            username = properties.getProperty("jdbc.user");
            password = properties.getProperty("jdbc.password");
        } catch (IOException e) {
            System.out.println("读取配置文件失败");
            e.printStackTrace();
        }
    }

    /**
     * 获取一个数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection(){
        try {
            /*
             * 通过DriverManager创建一个数据库的连接 并返回
             */
            Class.forName(driverClassName);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            // 通知调用者，创建连接出错
            System.out.println("创建数据库连接失败");
        }
        return null;
    }
    /**
     * 关闭给定的连接
     */
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

