package org.feng.framework.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    //数据库配置
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "java:mysql://localhost:3306/demo";
    private static final String username = "root";
    private static final String password = "123456";

    //定义一个用于防止数据库连接的局部线程变量(使每个线程都拥有自己的连接)
    private static ThreadLocal<Connection> conContainer = new ThreadLocal<Connection>();
//    //定义一个数据库连接
//    private static Connection conn =null;
    //获取连接
    public static Connection getConnection(){
        Connection conn = conContainer.get();
        try{
            if (conn == null) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conContainer.set(conn);
        }
        return conn;
    }
    //关闭连接
    public static void closeConnection(){
        Connection conn = conContainer.get();
        try {
            if (conn !=null){
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conContainer.remove();
        }
    }
}
