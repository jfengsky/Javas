package com.ieake.mysql;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Unit test for simple App.
 * "jdbc:mysql://localhost:3306/db3?useSSL=false","root","MDixNgh$2TY2YtKu"
 */
public class AppTest {

    private final String address = "jdbc:mysql:///student?useSSL=false";
    private final String user = "root";
    private final String pwd = "MDixNgh$2TY2YtKu";

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void createTable() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(address, user, pwd);
        Statement stat = conn.createStatement();
        stat.executeUpdate("create table tab_user(id int primary key not null, name varchar(100), age varchar(4), sex char, grade varchar(2))charset=utf8;");
        stat.close();
        conn.close();

    }

    @Test
    public void insertData() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(address, user, pwd);
        Statement stat = conn.createStatement();
        String sql = "insert into tab_user(id, name, age,sex,grade) values(5,'孙二',21,'男',4)";
        stat.executeUpdate(sql);
        stat.close();
        conn.close();
    }

}
