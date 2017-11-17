package com.example.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 账号实体
 *
 * @author   倪元法
 * @myblog  http://www.2568554895.com
 * @create    2017年11月17日
 */
@Entity
public class User {
        //id自增
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String username;
        private String password;
        public User() {
        }
        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public void setUserName(String userName) {
         this.username=userName;
        };
        public String getUserName(){
        return username;
        };
        public void setPassword(String password) {
        this.password=password;
        };
        public String getPassword(){
        return password;
        };


}
