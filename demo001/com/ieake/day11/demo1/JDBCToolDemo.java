package com.ieake.day11.demo1;

import java.sql.*;

public class JDBCToolDemo {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet rs = null;

        try {
            String sql = "update test set name = ? where id = ?";
            conn = JDBCTool.getConnect();
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(sql);

            pstat.setString(1, "周");
            pstat.setInt(2, 3);

            pstat.execute();
            conn.commit();
        } catch (SQLException e) {
            try {
                if(conn != null){
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCTool.close(rs, pstat, conn);
        }

//        try {
//            conn = JDBCTool.getConnect();
//            stat = conn.createStatement();
//            String sql = "update test set name = '孙九' where id = 3";
//            int count = stat.executeUpdate(sql);
//            if (count > 0) {
//                System.out.println("success");
//            } else {
//                System.out.println("fails");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            JDBCTool.close(rs, stat, conn);
//        }
    }
}
