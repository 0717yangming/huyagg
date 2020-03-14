package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.pojo.User;
import com.ym.hygg.huyagg.service.TokenService;
import com.ym.hygg.huyagg.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Transactional
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

    /**
     * 登录，添加transactional环境，解决 no session 问题
     * @param userlogin
     * @return
     */
    @Transactional
    @GetMapping("/login")
    public ResponseObject login(@Param("username") String username, @Param("password") String password){
        log.info(username+"：用户试图登陆");
        ResponseObject ro = new ResponseObject();
        System.out.println(username+":"+password);
        Optional<User> user = userService.getUserByNameAndPassword(username, password);
        if(!user.isPresent())
        {
            log.info(username+"：登录失败");
            ro.setMsg("用户名或密码错误");
            ro.setCode(ResponseObject.Reject);
           return ro;
        }
        System.out.println(user);
        ro.setObject(user);
        String token = tokenService.getToken(user.get());
        ro.setToken(token);
        ro.setCode(ResponseObject.SUCCESS);
        ro.setMsg("登录成功！");
        return ro;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Transactional
    @PostMapping
    public ResponseObject create(@RequestBody User user){
        System.out.println(user+"----->正在注册<---");
        ResponseObject ro= new ResponseObject();
        long timeMillis = System.currentTimeMillis();
        System.out.println(new Date(timeMillis));
        user.setCreateTime(new Date(timeMillis));
        User save = null;
        save  =  userService.save(user);
        if(save!=null) {
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("注册成功");
            ro.setObject(save);
            return ro;
        }
        else {
            ro.setCode(ResponseObject.Reject);
            ro.setMsg("注册失败");
            return ro;
        }

    }
}
