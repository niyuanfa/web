package com.example.spring.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/saveUser")
    @ResponseBody
    String SaveUser(String userName,String password){
        users.put(userName,password);
        return "保存成功";
    }

    @PostMapping("/all")
    @ResponseBody
    public String all() {
        System.out.println(users);
        return ""+users;
    }

    @PostMapping("/finduser")
    @ResponseBody
    public String finduser(String userName) {
     if(users.containsKey(userName))
     {String password=users.get(userName).toString();
         return password;}
     else
         return "未找到该用户";
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(String userName) {
        users.remove(userName);
        return "删除成功";
    }
    @PostMapping("/update")
    @ResponseBody
    public String update(String userName,String password) {
        users.put(userName,password);
        return "更新";
    }

}
