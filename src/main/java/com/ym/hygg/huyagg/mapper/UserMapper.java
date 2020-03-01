package com.ym.hygg.huyagg.mapper;

import com.ym.hygg.huyagg.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    List<User> getAllUser();
    @Select("SELECT * FROM user WHERE uid = #{uid}")
    User getUserByUId(Integer uid);
    int save(User user);
    @Select("SELECT * FROM user WHERE username = #{username} and password = #{password}")
    User getUserByNameAndPassword(String username,String password);
}
