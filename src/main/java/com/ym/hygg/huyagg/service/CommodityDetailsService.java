package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.CommodityDetails;

public interface CommodityDetailsService {
    CommodityDetails geoOneById(Integer commodityId);
    Integer save(CommodityDetails commodityDetails);
    boolean update(CommodityDetails commodityDetails);
}
