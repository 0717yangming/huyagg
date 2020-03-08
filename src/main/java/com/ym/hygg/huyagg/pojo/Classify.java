package com.ym.hygg.huyagg.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "classify")
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class Classify {
    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;
    /**
     * 分类名
     */
    private String className;
    /**
     * 属于该类名的商品集合
     */
    @JsonIgnore
    @OneToMany(mappedBy = "classify")
    private Set<Commodity> commodities = new HashSet<>(0);
    /**
     * 类名图片
     */
    @Column(name = "image_path", columnDefinition = "varchar(32) default 'sale.jpg'")
    private String imagePath;
}
