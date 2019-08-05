package com.ieake.day11.demo1;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTool {

//    private static String url;
//    private static String user;
//    private static String password;
//    private static String driver;

    private static String url = "jdbc:mysql:///db3?useSSL=false";
    private static String user = "root";
    private static String password = "MDixNgh$2TY2YtKu";
    private static String driver = "test";

    static {

//        try {
//            Properties pro = new Properties();
//            pro.load(new FileReader("src/jdbc.properties"));
//            url = pro.getProperty("url");
//            user = pro.getProperty("user");
//            password = pro.getProperty("password");
//            driver = pro.getProperty("driver");
//
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // 释放资源
    public static void close(ResultSet rs, Statement stat, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
