package com.ieake.day11.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcSearch {
    public static void main(String[] args) throws Exception {
        // mysql5 之后可以省略下面注册驱动写法
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db3?useSSL=false","root","MDixNgh$2TY2YtKu");
        Statement stat = conn.createStatement();

        ResultSet result = stat.executeQuery("select * from test");

        while (result.next())
        {
            System.out.println(result.getInt("id") + " " + result.getString("name"));
        }

        //关闭数据库
        result.close();
        stat.close();
        conn.close();
    }
}
