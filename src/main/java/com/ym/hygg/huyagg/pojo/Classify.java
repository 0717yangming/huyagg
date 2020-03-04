package com.ym.hygg.huyagg.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DynamicUpdate
@DynamicInsert
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classify {
    @Id
    @Column(name = "class_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;
    private String className;
    @OneToMany
    @JoinColumn(name = "class_id", referencedColumnName = "class_id")
    private Set<Commodity> commodities = new HashSet<>(0);
    @Column(name = "image_path", columnDefinition = "varchar(32) default 'sale.jpg'")
    private String imagePath;
}
