package com.ieake.day11.demo2;

import com.ieake.day11.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        // 添加一条记录
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 定义sql
            String sql = "insert into test Values(?,?)";

            // 获取pstmt对象
            pstmt = conn.prepareStatement(sql);

            // 给pstmt赋值
            pstmt.setInt(1, 4);
            pstmt.setString(2, "钱钱");


            // 执行sql
            int count = pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt, conn);
        }
    }
}
