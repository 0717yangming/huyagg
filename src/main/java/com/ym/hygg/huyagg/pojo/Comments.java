package com.ym.hygg.huyagg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date date;
    /**
     * 评论者
     */
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;
    /**
     * 评论在那个商品商品上
     */
    @ManyToOne
    @JoinColumn(name = "com_id")
    private Commodity commodity;
}
