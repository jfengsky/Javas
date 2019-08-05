/**
 * 创建表并写入测试数据
 */
package com.ieake.day11.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcCreateTable {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3?useSSL=false","root","MDixNgh$2TY2YtKu");
        Statement stat = conn.createStatement();

        //创建表test
        stat.executeUpdate("create table test(id int, name varchar(80))");

        //添加数据
        stat.executeUpdate("insert into test values(1, '张三')");
        stat.executeUpdate("insert into test values(2, '李四')");

        stat.close();
        conn.close();
    }
}
