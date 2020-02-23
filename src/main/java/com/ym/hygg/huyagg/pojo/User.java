package com.ym.hygg.huyagg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

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

    private int reputation;
    private String state;
    private String who;
    private Date createTime;
}
