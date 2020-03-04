package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.pojo.User;
import com.ym.hygg.huyagg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public User getUserByNameAndPassword(String username, String password) {
        return null;
    }
}
