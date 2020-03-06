package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
    @Query(value = "FROM User WHERE username = ?1 AND password = ?2")
     User getUserByUserNameAndPwd(String username, String password);
}
