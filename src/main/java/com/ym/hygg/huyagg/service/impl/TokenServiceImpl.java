package com.ym.hygg.huyagg.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ym.hygg.huyagg.pojo.User;
import com.ym.hygg.huyagg.service.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService{
    @Override
    public String getToken(User user) {
        String token="";
        token= JWT.create().withAudience(user.getUid().toString(),user.getState().toString(),user.getRole().toString())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
