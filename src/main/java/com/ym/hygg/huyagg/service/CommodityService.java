package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommodityService {
    List<Commodity> queryAllCommodity();
    Optional<Commodity> getCommodityById(Integer id);
    List<Commodity> getCommoditiesByType(Integer classify);
    Commodity save(Commodity commodity);
    void delete(Integer id);
}
