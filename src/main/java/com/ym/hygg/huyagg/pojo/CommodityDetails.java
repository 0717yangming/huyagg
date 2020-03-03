package com.ym.hygg.huyagg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class CommodityDetails {
    @Id
    private Integer id;
    private String details;
    private String comments;
    private Integer collect;
    private Integer sold;
    @OneToOne(mappedBy = "commodityDetails")
    private Commodity commodity;
}
