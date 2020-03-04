package com.ym.hygg.huyagg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class CommodityDetails {
    @Id
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdId;
    private String details;
    private String comments;
    private Integer collect;
    private Integer sold;
    @OneToOne
    private Commodity commodity;
}
