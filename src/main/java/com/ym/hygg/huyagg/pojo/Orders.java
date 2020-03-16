package com.ym.hygg.huyagg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serial;
    /**
     * 保存订单中的商品id，用 "," 隔开
     * 没必要描述多对多的关系，将订单查询出来后再那这一列去查询商品就好了
     */
    @Column(name = "commodities_id")
    private String commoditiesId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss", timezone = "GMT+8")
    private Date createTime;
}
