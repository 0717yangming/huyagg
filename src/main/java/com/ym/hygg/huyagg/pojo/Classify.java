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
@Table(name = "classify" )
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
    @Column(name = "class_name")
    private String className;

    /**
     * 类名图片
     */
    @Column(name = "image_path", columnDefinition = "varchar(32) default 'sale.jpg'")
    private String imagePath;

    @OneToMany(mappedBy = "classId")
    private Set<Commodity> commodity;
}
