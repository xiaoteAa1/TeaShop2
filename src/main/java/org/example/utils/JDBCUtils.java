package org.example.utils;

import java.sql.*;

public class JDBCUtils {
    private static String url = "jdbc:mysql://120.79.223.83:3306/teaShop2?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static String user = "root";
    private static String password = "lxj123456";

    //获取连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public static void close(ResultSet rs, Statement stm, Connection con){
        //资源释放
        if(stm !=null){
            try {
                stm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }if(con !=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }if(rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stm){
        //资源释放
        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stm !=null){
            try {
                stm.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}