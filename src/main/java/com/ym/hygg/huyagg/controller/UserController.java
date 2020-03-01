package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.pojo.User;
import com.ym.hygg.huyagg.service.TokenService;
import com.ym.hygg.huyagg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/{uid}")
    public ResponseObject getUserById(@PathVariable Integer uid){
        System.out.println(uid);
        User user = userService.getUserById(uid);
        ResponseObject responseObject = new ResponseObject();
        if(user!=null){
        System.out.println(user.getCreateTime());
        responseObject.setCode(200);
        responseObject.setMsg("查询成功!");
        responseObject.setObject(user);
        return responseObject;
        }
        else {
            responseObject.setCode(ResponseObject.SUCCESS);
            responseObject.setMsg("查无此人!");
            responseObject.setObject(null);
            return responseObject;
        }

    }
    @GetMapping("/login")
    public Map<String,Object> login(@RequestBody User userlogin){
        System.out.println(userlogin.getUsername()+":"+userlogin.getPassword());
        Map<String,Object> map = new HashMap<>();
        User user = userService.getUserByNameAndPassword(userlogin.getUsername(), userlogin.getPassword());
        System.out.println(user);
        map.put("user",user);
        String token = tokenService.getToken(user);
        map.put("token",token);
        return map;
    }
    @PostMapping
    public User create(@RequestBody User user){
        System.out.println(user);
        long timeMillis = System.currentTimeMillis();
        System.out.println(new Date(timeMillis));
        user.setCreateTime(new Date(timeMillis));
        int i =  userService.save(user);
        System.out.println("添加了"+i+"条记录");
        return user;
    }
}
