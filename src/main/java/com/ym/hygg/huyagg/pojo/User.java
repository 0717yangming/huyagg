package com.ym.hygg.huyagg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.criterion.Order;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@DynamicInsert
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user",indexes = @Index(columnList = "username"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    /**
     * 学院
     */
    @NotNull
    private String academy;
    /**
     * 班级
     */
    private String banji;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 宿舍
     */
    private String domitory;
    /**
     * 专业
     */
    private String major;
    /**
     * 用户名
     */
    @Column(name = "username", unique = true)
    private String username;
    /**
     * 真实姓名
     */
    private String actualName;
    /**
     * 密码
     */
    private String password;
    /**
     * 电话
     */
    private String phone;
    /**
     * 性别
     */
    private String sex;
    /**
     * 信誉分
     */
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
    /**
     * 账户的创建时间
     */

    @JsonFormat(pattern = "yyyy-MM-hh hh:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 所属的商品列表
     */
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Commodity> commodities = new HashSet<>(0);
    /**
     * 评论
     */
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Comments> comments = new HashSet<>(0);
    @JsonIgnore
    @OneToMany( mappedBy = "user")
    private Set<Orders> orders;
}
