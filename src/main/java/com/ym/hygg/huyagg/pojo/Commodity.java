package com.ym.hygg.huyagg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@DynamicUpdate
@DynamicInsert
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "commodity")
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品价格
     */
    private Double price;
    /**
     * 图片名称
     */
    private String picName;
    /**
     * 发布时间
     */
   // @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss"
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date releaseTime;
    /**
     * 商品所属用户
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "uid")
    private User user;
    /**
     * 商品的详情
     */
    @OneToOne(mappedBy = "commodity")
    private CommodityDetails commodityDetails;
    /**
     *  默认值为0，代表待审核
     *  管理员审核完后，值为审核者的id
     */
    @Column(name = "audit", columnDefinition = "int default 0")
    private Integer audit;
    /**
     * 商品的分类
     */
    @ManyToOne(targetEntity = Classify.class)
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Classify classify;
}
