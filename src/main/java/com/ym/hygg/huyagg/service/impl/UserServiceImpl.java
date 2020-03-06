package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.dao.UserRepository;
import com.ym.hygg.huyagg.pojo.User;
import com.ym.hygg.huyagg.service.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getUserById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public User save(User user)
    {
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public User getUserByNameAndPassword(String username, String password)  {
        User save = userRepository.getUserByUserNameAndPwd(username, password);
        Optional<User> opt = Optional.ofNullable(save);
        return opt.get();
    }
}
