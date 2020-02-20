package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.mapper.CommodityMapper;
import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityMapper commodityMapper;
    @Override
    public List<Commodity> queryAllCommodity() {
        List<Commodity> commodities = commodityMapper.getAllCommodities();
        return commodities;
    }

    @Override
    public int save(Commodity commodity) {
        return commodityMapper.save(commodity);
    }

    @Override
    public int delete(Integer id) {
        return commodityMapper.delete(id);
    }

    @Override
    public int update(Commodity commodity) {
        return commodityMapper.updateByExample(commodity);
    }

    @Override
    public Commodity getCommodityById(Integer id) {
        return commodityMapper.GetCommodityById(id);
    }

    @Override
    public List<Commodity> getCommoditiesByType(Integer classify) {
        return commodityMapper.getCommoditiesByType(classify);
    }
}
