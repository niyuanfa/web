package com.example.spring.controll;

import com.example.spring.repository.UserRepository;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserControll {

    private static final Logger logger = LoggerFactory.getLogger(UserControll.class);

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @PostMapping("/saveUser")
    @ResponseBody
    public User SaveUser(@RequestParam(value = "username", required = false, defaultValue = "") String username,
                           @RequestParam(value = "password", required = false, defaultValue = "") String password) throws Exception {
        User user=new User(username,password);
        System.out.println(user);
        if(StringUtils.isEmpty(username)){
            throw new  NullPointerException("用户名不能为空");}
            List list=this.finduser(username);
        if(!CollectionUtils.isEmpty(list)){
                throw new  NullPointerException("该用户已存在");
        }

        return userRepository.save(user);
    }

    @GetMapping("/all")
    @ResponseBody
        public List<User> getUser(){
            logger.info("从数据库读取user");
            return userRepository.findAll();
    }
    @PostMapping("/update")
    @ResponseBody
    public User update(@RequestParam(value="username",required = false,defaultValue = "")String username,
                       @RequestParam(value = "password",required = false,defaultValue = "")String password) {
       User user=new User(username,password);
    return userRepository.saveAndFlush(user);
     }
    @PostMapping("/finduser")
    @ResponseBody
    public List<User> finduser(@RequestParam(value = "username",required = true,defaultValue = "")String username) throws Exception {
           return userRepository.findByUsername(username);
    }

}