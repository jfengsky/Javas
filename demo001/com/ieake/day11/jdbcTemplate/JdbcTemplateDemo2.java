package com.ieake.day11.jdbcTemplate;

import com.ieake.day11.demo1.Emp;
import com.ieake.day11.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo2 {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Test
    public void test1(){
        // 修改
        String sql = "update test set name = '武测' where id = 1";
        int count = template.update(sql);
        System.out.println(count);
    }

    @Test
    public void test2(){
        // 增加
        String sql = "insert into test(id, name) values(?,?)";
        int count = template.update(sql,5, "测伍");
        System.out.println(count);
    }

    @Test
    public void test3(){
        // 删除
        String sql = "delete from test where id = ?";
        int count = template.update(sql,5);
        System.out.println(count);
    }

    @Test
    public void test4(){
        // 查询1条
        String sql = "select * from test where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
    }

    @Test
    public void test5(){
        // 查询多条
        String sql = "select * from test ";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

    @Test
    public void test6(){
        // 查询多条,并返回对象
        String sql = "select * from test ";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                emp.setId(id);
                emp.setName(name);
                return emp;
            }
        });
        System.out.println(list);
    }

    @Test
    public void test6_2(){
        // 查询多条,并返回对象
        String sql = "select * from test ";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for(Emp emp:list) {
            System.out.println(emp);
        }
    }

    @Test
    public void test7(){
        // 查询记录数
        String sql = "select count(id) from test ";
        Long total = template.queryForObject(sql, long.class);
        System.out.println(total);
    }
}
