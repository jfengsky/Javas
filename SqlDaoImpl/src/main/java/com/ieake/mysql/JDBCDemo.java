package com.ieake.mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Student> list = new JDBCDemo().findAll();
        System.out.println(list);
    }

    /**
     * 查询所有学生方法
     * @return
     */
    public List<Student> findAll() throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql:///student?useSSL=false", "root", "MDixNgh$2TY2YtKu");

        //定义sql
        String sql = "select * from tab_user";

        // 获取执行sql对象
        Statement stmt = conn.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 遍历结果集 封装对象 封装集合

        Student student = null;

        List<Student> list = new ArrayList<Student>();
        while(rs.next()){
            // 获取数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String sex = rs.getString("sex");
            int age = rs.getInt("age");
            int grade = rs.getInt("grade");

            student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            student.setSex(sex);
            student.setGrade(grade);
            list.add(student);
        }
        rs.close();
        stmt.close();
        conn.close();

        return list;
    }
}
