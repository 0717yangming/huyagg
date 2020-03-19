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
import java.util.Set;

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
    @Column(name = "com_id")
    private Integer comId;
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
    @Column(name = "pic_name")
    private String picName;
    /**
     * 发布时间
     */
   // @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss"
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    @Column(name = "release_time")
    private Date releaseTime;
    /**
     * 商品所属用户或发布需求的用户
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    /**
     * 商品的详情
     */
    @OneToOne(mappedBy = "commodity")
    private CommodityDetails commodityDetails;
    /**
     *  默认值为0，代表待审核
     *  管理员审核完后，
     */
    @Column(name = "audit", columnDefinition = "int default 0")
    private Integer audit;
    /**
     *区分商品是需求还是销售
     * 0 代表是买家发布的需求
     * 1 代表卖家发布的商品
     */
    @Column(name = "distinguish")
    private Integer distinguish;
    /**
     * 商品的分类
     */
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Classify classify;

    /**
     * 描述商品和评论之间的关系
     * 一个商品都应该对应对各评论
     * 放弃外键维护
     */
    @OneToMany(mappedBy = "commodity")
    private Set<Comments> comments;
}
