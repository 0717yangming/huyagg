package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CommodityServiceImpl implements CommodityService {

    @Override
    public List<Commodity> queryAllCommodity() {
        //List<Commodity> commodities = commodityMapper.commodityWithAudited();
        System.out.println();
        return null;
    }

    @Override
    public int save(Commodity commodity) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int update(Commodity commodity) {
        return 0;
    }

    @Override
    public Commodity getCommodityById(Integer id) {
        return null;
    }

    @Override
    public List<Commodity> getCommoditiesByType(Integer classify) {
        return null;
    }
}
