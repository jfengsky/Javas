package com.ieake.day11.demo1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo8 {

    public static void main(String[] args) {
        List<Emp> list = new JDBCDemo8().findAll();
        System.out.println(list);
    }

    public List<Emp> findAll() {
        Connection conn = null;
        Statement stat = null;
        ResultSet result = null;
        List<Emp> list = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3?useSSL=false", "root", "MDixNgh$2TY2YtKu");
            String sql = "select * from test";
            stat = conn.createStatement();
            result = stat.executeQuery(sql);
            Emp emp = null;
            list = new ArrayList<>();
            while(result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");

                emp = new Emp();
                emp.setId(id);
                emp.setName(name);

                list.add(emp);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(result != null){
                try {
                    result.close();
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

        return list;
    }
}
