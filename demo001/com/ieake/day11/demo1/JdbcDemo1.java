/**
 * 创建数据
 */

package com.ieake.day11.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false","root","MDixNgh$2TY2YtKu");

        // 创建 db3 数据库
        Statement stat = conn.createStatement();
        stat.executeUpdate("create database db3");
        stat.close();
        conn.close();
    }
}
