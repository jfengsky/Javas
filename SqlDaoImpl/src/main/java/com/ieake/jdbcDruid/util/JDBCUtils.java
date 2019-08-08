package com.ieake.jdbcDruid.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.ieake.druid.DruidDemo;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC 连接池工具类
 */
public class JDBCUtils {

    // 定义成员变量 DataSource
    private static DataSource ds;

    static {
        // 加载配置文件
        Properties pro = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properites");

        // 加载配置对象
        try {
            pro.load(is);
            // 获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn){
        close(null, stmt, conn);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 返回连接池
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
