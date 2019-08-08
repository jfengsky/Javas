package com.ieake.jdbcDruid;

import com.ieake.jdbcDruid.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 获取连接
            conn = JDBCUtils.getConnection();

            // 定义sql
            String sql = "insert into tab_user values(?, ?, ?, ?, ?)";

            // 获取pstm对象
            pstmt = conn.prepareStatement(sql);

            //给?赋值
            pstmt.setInt(1, 6);
            pstmt.setString(2, "周小");
            pstmt.setInt(3, 22);
            pstmt.setString(4, "女");
            pstmt.setInt(5, 23);

            // 执行sql
            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt,conn);
        }

    }
}
