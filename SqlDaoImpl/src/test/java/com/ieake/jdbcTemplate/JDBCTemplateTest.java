package com.ieake.jdbcTemplate;

import com.ieake.jdbcDruid.util.JDBCUtils;
import com.ieake.mysql.Student;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTemplateTest {

    /**
     * 查询的结果封装为Map集合,只能查询1条
     */
    @Test
    public void testMap(){

        // 创建jdbc对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "select * from tab_user where id = ?";

        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
        System.out.println(map.get("name"));

    }

    /**
     * 封装成List
     */
    @Test
    public void testList(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from tab_user where id = ? or id = ?";
        List<Map<String, Object>> list = template.queryForList(sql, 1, 2);
        System.out.println(list);
        for (Map<String, Object> map : list) {
            System.out.println(map);
            System.out.println(map.get("name"));
        }
    }

    /**
     * 复杂封装方法
     */
    @Test
    public void testStudent(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from tab_user";
        List<Student> list = template.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int i) throws SQLException {
                Student student = new Student();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                int grade = rs.getInt("grade");
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                student.setSex(sex);
                student.setGrade(grade);
                return student;
            }
        });

        for (Student student : list) {
            System.out.println(student);
        }
    }

    /**
     * 简单封装方法
     */
    @Test
    public void testStudent2(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from tab_user";
        List<Student> list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
