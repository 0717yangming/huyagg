package com.ym.hygg.huyagg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "commodity_details")
public class CommodityDetails {
    @Id
    @Column(name = "cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cdId;
    /**
     * 详情描述
     */
    private String details;
    /**
     * 收藏
     */
    private Integer collect;
    /**
     * 已售
     */
    private Integer sold;

    @OneToOne
    @JoinColumn(name = "com_id")
    private Commodity commodity;
}
