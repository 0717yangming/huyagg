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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long serial;
    @ManyToMany(targetEntity = Commodity.class)
    @JoinTable(name="orders_commodity_rel",//中间表的名称
            //中间表orders_commodity_rel字段关联sys_role表的主键字段role_id
            joinColumns={@JoinColumn(name="orders_id",referencedColumnName="serial")},
            //中间表orders_commodity_rel的字段关联sys_user表的主键user_id
            inverseJoinColumns={@JoinColumn(name="commodity_id",referencedColumnName="id")}
    )
    private Set<Commodity> commodity;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "uid")
    private User user;
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss", timezone = "GMT+8")
    private Date createTime;
}
