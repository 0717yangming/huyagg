package com.ym.hygg.huyagg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@Data
@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_id")
    private Integer commentsId;
    /**
     * 评论描述
     */
    private String describes;
    /**
     * 评论时间
     */
    private Date date;
    /**
     * 评论者
     */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "uid")
    private User user;
    @ManyToOne
    @JoinColumn(name = "cd_id",referencedColumnName = "cd_id")
    private CommodityDetails commodityDetails;
}
