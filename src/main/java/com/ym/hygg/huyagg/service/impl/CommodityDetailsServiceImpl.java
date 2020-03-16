package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.dao.CommodityDetailsDao;
import com.ym.hygg.huyagg.pojo.CommodityDetails;
import com.ym.hygg.huyagg.service.CommodityDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommodityDetailsServiceImpl implements CommodityDetailsService {
    @Resource
    private CommodityDetailsDao commodityDetailsDao;
    @Override
    public CommodityDetails geoOneById(Integer commodityId) {
        return commodityDetailsDao.geoOneById(commodityId);
    }

    @Override
    public Integer save(CommodityDetails commodityDetails) {
        return commodityDetailsDao.save(commodityDetails);
    }

    @Override
    public boolean update(CommodityDetails commodityDetails) {
        return commodityDetailsDao.update(commodityDetails);
    }
}
