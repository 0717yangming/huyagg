package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommodityService {
    List<Commodity> queryAllCommodity();
    Commodity getCommodityById(Integer id);
    List<Commodity> getCommoditiesByType(Integer classify);
    int save(Commodity commodity);
    int delete(Integer id);
    int update(Commodity commodity);
}
