package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.User;

public interface UserService {
    User getUserById(Integer id);
    User save(User user);
    User getUserByNameAndPassword(String username,String password);
}
