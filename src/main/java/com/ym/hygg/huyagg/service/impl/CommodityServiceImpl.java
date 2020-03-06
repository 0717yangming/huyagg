package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.dao.CommodityRepository;
import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityRepository commodityRepository;
    @Override
    public List<Commodity> queryAllCommodity() {
        //List<Commodity> commodities = commodityMapper.commodityWithAudited();
        return commodityRepository.findAll();
    }

    @Override
    public Commodity save(Commodity commodity) {
        return commodityRepository.save(commodity);
    }

    @Override
    public void delete(Integer id) {
        commodityRepository.deleteById(id);
    }
    @Override
    public Optional<Commodity> getCommodityById(Integer id) {
        return commodityRepository.findById(id);
    }

    @Override
    public List<Commodity> getCommoditiesByType(Integer classify) {
        return commodityRepository.getCommoditiesByType(classify);
    }
}
