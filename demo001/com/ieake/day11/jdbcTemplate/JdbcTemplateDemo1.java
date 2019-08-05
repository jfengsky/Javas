package com.ieake.day11.jdbcTemplate;

import com.ieake.day11.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {

        // 创建对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "update test set name = '吴天' where id = ?";

        // 调用方法
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
