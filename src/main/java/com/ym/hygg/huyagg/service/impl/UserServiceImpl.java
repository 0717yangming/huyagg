package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.mapper.UserMapper;
import com.ym.hygg.huyagg.pojo.User;
import com.ym.hygg.huyagg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserById(long id) {
        return userMapper.getUserByUId(id);
    }

    @Override
    public int save(User user) {
        return userMapper.save(user);
    }
}
