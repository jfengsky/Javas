package com.ieake.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 使用druid连接池demo
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 定义配置文件
        Properties pro = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properites");

        // 加载配置对象
        pro.load(is);

        // 获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        // 获取连接
        Connection conn = ds.getConnection();
    }
}
