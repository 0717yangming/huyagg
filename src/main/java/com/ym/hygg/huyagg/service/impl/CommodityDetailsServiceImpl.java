package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.dao.CommodityDetailsRepository;
import com.ym.hygg.huyagg.pojo.CommodityDetails;
import com.ym.hygg.huyagg.service.CommodityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityDetailsServiceImpl implements CommodityDetailsService {
    @Autowired
    private CommodityDetailsRepository commodityDetailsRepository;
    @Override
    public CommodityDetails ByCommodityId(Integer commodityId) {
        return commodityDetailsRepository.ByCommodityId(commodityId);
    }
}
