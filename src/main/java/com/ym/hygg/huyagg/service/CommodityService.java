package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommodityService {
    List<Commodity> queryAllCommodity();
    int save(Commodity commodity);
    int delete(Integer id);
    int update(Commodity commodity);
}
