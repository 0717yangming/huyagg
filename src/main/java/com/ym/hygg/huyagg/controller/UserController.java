package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.pojo.User;
import com.ym.hygg.huyagg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/getUserById/{uid}")
    public User getUserById(@PathVariable Long uid){
        System.out.println(uid);
        User user = userService.getUserById(uid);
        System.out.println(user.getCreateTime());
        return  user;
    }
    @PostMapping("/save")
    public User create(@RequestBody User user){
        System.out.println(user);
        int ram = (int)((Math.random()*100));
        long timeMillis = System.currentTimeMillis();
        user.setUid(timeMillis + ram);
        System.out.println(new Date(timeMillis));
        user.setCreateTime(new Date(timeMillis));
        int i =  userService.save(user);
        System.out.println("添加了"+i+"条记录");
        return user;
    }
}
