package com.ym.hygg.huyagg.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityDetailsDao {
    com.ym.hygg.huyagg.pojo.CommodityDetails geoOneById(Integer commodityId);
    Integer save(com.ym.hygg.huyagg.pojo.CommodityDetails commodityDetails);
    boolean update(com.ym.hygg.huyagg.pojo.CommodityDetails commodityDetails);
}
