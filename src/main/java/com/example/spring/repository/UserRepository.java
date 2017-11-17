package com.example.spring.repository;

import com.example.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
    /**
     * \根据用户名批量查询用户数据
     *
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

}
