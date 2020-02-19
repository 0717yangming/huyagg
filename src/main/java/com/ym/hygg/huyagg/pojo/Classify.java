package com.ym.hygg.huyagg.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
}
