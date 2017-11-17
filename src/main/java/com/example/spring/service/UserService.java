package com.example.spring.service;

import com.example.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getList(){
        String sql="SELECT * FROM `user`";
        return (List<User>)jdbcTemplate.query(sql,new RowMapper<User>(){

            @Override

            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                 User us=new User();
                 us.setUserName(rs.getString("userName"));
                 us.setPassword(rs.getInt("password"));
                 return us;
            }
        });

    }
}
