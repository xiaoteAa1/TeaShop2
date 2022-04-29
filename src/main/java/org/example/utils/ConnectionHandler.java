package org.example.utils;

import java.sql.*;

/**
 * 提前在此把Connection创建完毕，并且放入ThreadLocal
 */
public class ConnectionHandler {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal();

    public static Connection getConnection() {
        Connection conn = threadLocal.get();//从ThreadLocal中取数据

        if (conn == null) {
            String user = "root";
            String dbPassword = "Li123456";
            String url = "jdbc:mysql://172.16.87.55:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            try {
                conn = DriverManager.getConnection(url, user, dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.set(conn);
        }

        return conn;
    }

    public static void closeConnection() {
        Connection conn = threadLocal.get();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.remove();
        }
    }
}