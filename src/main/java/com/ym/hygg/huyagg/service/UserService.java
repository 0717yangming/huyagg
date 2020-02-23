package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.User;

public interface UserService {
    User getUserById(long id);
    int save(User user);
    User getUserByNameAndPassword(String username,String password);
}
