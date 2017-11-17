package com.example.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
/**
 * 账号实体
 *
 * @author   倪元法
 * @myblog  http://www.2568554895.com
 * @create    2017年11月17日
 */

@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User implements Serializable  {
    private static final long serialVersionUID = 2120869894112984147L;
    private String UserName;
    private int Password;
    public String setUserName(String userName) {
        System.out.println(userName);
        return this.UserName=userName;
    };
    public int setPassword(int password) {
        System.out.println(password);
        return this.Password=password;
    };
}
