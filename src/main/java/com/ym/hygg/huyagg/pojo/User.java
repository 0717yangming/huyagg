package com.ym.hygg.huyagg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "user")
public class User {
    @Id
    private Integer uid;

    @NotNull
    private String academy;
    private String banji;
    private String email;
    private String domitory;
    private String major;
    private String username;
    private String actualName;
    private String password;
    private String phone;
    private String sex;
    @Column(name = "reputation",columnDefinition = "int default 100")
    private Integer reputation;
    /**
     * 1：正常
     * 2：禁用
     */
    @Column(name = "state",columnDefinition = "int default 1")
    private Integer state;
    /**
     * 1: 普通用户
     * 2： 管理员
     */
    @Column(name = "role",columnDefinition = "int default 1")
    private Integer role;
    private Date createTime;
}
