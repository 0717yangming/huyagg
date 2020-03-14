package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.User;

import java.util.Optional;

public interface UserService {
    User getUserById(Integer id);
    User save(User user);
    Optional<User> getUserByNameAndPassword(String username, String password);
}
