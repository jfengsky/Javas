package com.ieake.day11.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDml {

    public static void main(String[] args) {
        String sql = "insert into test values(3, '王五')";
        Connection conn = null;
        Statement stat = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql:///db3?useSSL=false", "root", "MDixNgh$2TY2YtKu");

            stat = conn.createStatement();

            int count = stat.executeUpdate(sql);

            if (count > 0) {
                System.out.println("success");
            } else {
                System.out.println("fails");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
}
