package com.ym.hygg.huyagg.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@DynamicUpdate
@DynamicInsert
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classify {
    @Id
    private Integer classId;
    private String className;
    @OneToMany
    @JsonBackReference
    private List<Commodity> commodities;
    @Column(name = "image_path", columnDefinition = "varchar(32) default 'sale.jpg'")
    private String imagePath;
}
