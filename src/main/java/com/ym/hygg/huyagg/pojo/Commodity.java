package com.ym.hygg.huyagg.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@DynamicUpdate
@DynamicInsert
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commodity {
    @Id
    private Integer id;
    private String name;
    private Double price;
    private String details;
    private String picName;
   // @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss"
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss" ,timezone = "GMT+8")
    private Date addTime;
    private Integer owner;
    /**
     *  默认值为0，代表待审核
     *  管理员审核完后，值为审核者的id
     */
    @Column(name = "audit",columnDefinition = "int default 0")
    private Integer audit;
    @ManyToOne
    @JoinColumn(name = "classify")
    private Classify classifyName;
    @Transient
    private Integer classify;
    @JsonIgnore
    public Integer getClassify() {
        return classify;
    }
    @JsonProperty
    public void setClassify(Integer classify) {
        this.classify = classify;
    }
}
