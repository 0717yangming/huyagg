package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserDao {
    User getUserById(Integer id);
    Integer save(User user);
    boolean update(User user);
    User getOneByUsername(String username);
}
