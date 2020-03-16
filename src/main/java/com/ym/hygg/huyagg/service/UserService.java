package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.User;

import java.util.Optional;

public interface UserService {
    User getUserById(Integer id);
    Integer save(User user);
    boolean update(User user);
    Optional<User> getOneByUsername(String username);
}
