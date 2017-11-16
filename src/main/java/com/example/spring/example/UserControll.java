package com.example.spring.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserControll {

    public Map users = new HashMap();

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @GetMapping("/saveUser")
    @ResponseBody
    String SaveUser(String userName,String password){
        users.put(userName,password);
        return "保存成功";
    }

    @GetMapping("/all")
    @ResponseBody
    public String all() {
        System.out.println(users);
        return ""+users;
    }

    @GetMapping("/finduser")
    @ResponseBody
    public String finduser(String userName) {
     if(users.containsKey(userName))
     {String password=users.get(userName).toString();
         return "该用户密码为"+password;}
     else
         return "查找失败";
    }

    @GetMapping("/delete")
    @ResponseBody
    public String delete(String userName) {
        users.remove(userName);
        return "删除成功";
    }
    @GetMapping("/update")
    @ResponseBody
    public String update(String userName,String password) {
        users.put(userName,password);
        return "更新";
    }

}
