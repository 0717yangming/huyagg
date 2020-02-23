package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.User;

public interface TokenService {
    String getToken(User user);
}
