package com.example.spring.controll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.spring.service.UserService;
import com.example.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserControll {

    private static final Logger logger = LoggerFactory.getLogger(UserControll.class);

    @Autowired
    private UserService userService;
//    public Map users = new HashMap();
//
//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello() {
//        System.out.println("hello");
//        return "hello";
//    }
//
//    @PostMapping("/saveUser")
//    @ResponseBody
//    String SaveUser(String userName,String password){
//        users.put(userName,password);
//        return "保存成功";
//    }

    @PostMapping("/all")
    @ResponseBody
//    public String all() {
//        System.out.println(users);
//        return ""+users;
//    }
        public List<User> getUser(){
            logger.info("从数据库读取user");
            return userService.getList();
    }
    }



//    @PostMapping("/finduser")
//    @ResponseBody
//    public String finduser(String userName) {
//     if(users.containsKey(userName))
//     {String password=users.get(userName).toString();
//         return password;}
//     else
//         return "未找到该用户";
//    }
//
//    @PostMapping("/delete")
//    @ResponseBody
//    public String delete(String userName) {
//        users.remove(userName);
//        return "删除成功";
//    }
//    @PostMapping("/update")
//    @ResponseBody
//    public String update(String userName,String password) {
//        users.put(userName,password);
//        return "更新";
//    }

//}
