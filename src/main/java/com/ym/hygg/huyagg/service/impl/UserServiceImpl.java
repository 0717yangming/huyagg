package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.common.CommonUtils;
import com.ym.hygg.huyagg.dao.UserDao;
import com.ym.hygg.huyagg.pojo.User;
import com.ym.hygg.huyagg.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public Integer save(User user) {
         userDao.save(user);
        return user.getUid();
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }


    @Override
    public Optional<User> getOneByUsername(String username) {
        return Optional.ofNullable(userDao.getOneByUsername(username));
    }
}
