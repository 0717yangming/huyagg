package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.common.CommonUtils;
import com.ym.hygg.huyagg.dao.UserRepository;
import com.ym.hygg.huyagg.pojo.User;
import com.ym.hygg.huyagg.service.UserService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.hibernate.criterion.Example;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

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
        if(user.getUid() != null){
            String[] nullProperties = CommonUtils.getNullProperties(user);
            Optional<User> userOptional = userRepository.findById(user.getUid());
            if(userOptional.isPresent()){
                BeanUtils.copyProperties(user,userOptional.get(),nullProperties);
                user = userOptional.get();
            }
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByNameAndPassword(String username, String password)  {
        User save = userRepository.getUserByUserNameAndPwd(username, password);
        Optional<User> opt = Optional.ofNullable(save);
        return opt;
    }

}
