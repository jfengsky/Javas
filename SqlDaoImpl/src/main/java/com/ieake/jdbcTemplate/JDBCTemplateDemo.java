package com.ieake.jdbcTemplate;

/**
 * JdbcTemplate 入门
 */

import com.ieake.jdbcDruid.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateDemo {
    public static void main(String[] args) {

        // 创建jdbc对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        //定义sql
        String sql = "update tab_user set grade = 6 where id = ?";

        // 调用方法
        int count = template.update(sql, 6);
    }

}
