package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.dao.UserDao;
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

import javax.annotation.Resource;
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
    @Resource
    private UserService userService;
    @Resource
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
        }
        else {
            responseObject.setCode(ResponseObject.SUCCESS);
            responseObject.setMsg("查无此人!");
            responseObject.setObject(null);
        }
        return responseObject;

    }

    /**
     * 登录，添加transactional环境，解决 no session 问题
     * @return ResponseObject
     */
    @Transactional
    @GetMapping("/login")
    public ResponseObject login(@Param("username") String username, @Param("password") String password){
        log.info(username+"：用户试图登陆");
        ResponseObject ro = new ResponseObject();
        Optional<User> user = userService.getOneByUsername(username);
        if(!user.isPresent())
        {
            log.info(username+"：登录失败");
            ro.setMsg("用户名不存在！");
            ro.setCode(ResponseObject.Fail);
           return ro;
        }
        if (!(user.get().getPassword().equals(password))){
            log.info(username+"：登录失败");
            ro.setMsg("密码错误！");
            ro.setCode(ResponseObject.Fail);
            return ro;
        }
        ro.setObject(user.get());
        String token = tokenService.getToken(user.get());
        ro.setToken(token);
        ro.setCode(ResponseObject.SUCCESS);
        ro.setMsg("登录成功！");
        return ro;
    }

    /**
     * 注册用户
     * @return ResponseObject
     */
    @Transactional
    @PostMapping
    public ResponseObject create(@RequestBody User user){
        log.info(user.getUsername()+"====>正在注册");
        ResponseObject ro= new ResponseObject();
        long timeMillis = System.currentTimeMillis();
        user.setCreateTime(new Date(timeMillis));
        Integer save = null;
        save  =  userService.save(user);
        log.info("id---->"+save);
        if(save!=null) {
            log.info(user.getUsername()+"====>注册成功！");
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("注册成功");
            ro.setObject(save);
        }
        else {
            log.info(user.getUsername()+"====>注册失败！");
            ro.setCode(ResponseObject.Reject);
            ro.setMsg("注册失败");
        }
        return ro;
    }
    @Transactional
    @PutMapping
    public ResponseObject update(@RequestBody User user){
        ResponseObject ro= new ResponseObject();
        boolean update = userService.update(user);
        if(update){
            ro.setMsg("修改成功！");
            ro.setCode(ResponseObject.SUCCESS);
        }else{
            ro.setMsg("修改失败！");
            ro.setCode(ResponseObject.Fail);
        }
        return ro;
    }
}
