package com.shed.test;

import com.shed.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testInsert() {
        int rowUpdate = jdbcTemplate.update("INSERT INTO t_user VALUES(?,?,?)", 3,"Cindy", 22);
        System.out.println(rowUpdate);
    }
    
    @Test
    public void testQueryAll() {
        List<User> userList = jdbcTemplate.query("SELECT * FROM t_user", new BeanPropertyRowMapper<User>(User.class));
        for (User user : userList){
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate() {
        int rowUpdate = jdbcTemplate.update("UPDATE t_user SET name=?,age=? WHERE uid=?", "Brian", 25, 2);
        System.out.println(rowUpdate);
    }

    @Test
    public void testDelete() {
        int rowUpdate = jdbcTemplate.update("DELETE FROM t_user WHERE name=?", "Allen");
        System.out.println(rowUpdate);
    }
}
