package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.common.CommonUtils;
import com.ym.hygg.huyagg.dao.CommodityDao;
import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityDao commodityDao;
    @Override
    public List<Commodity> queryAllCommodity() {
        //List<Commodity> commodities = commodityMapper.commodityWithAudited();
        return commodityDao.queryAll();
    }

    @Override
    public Integer save(Commodity commodity) {
        if(commodity.getComId() != null){
            String[] nullProperties = CommonUtils.getNullProperties(commodity);
            Optional<Commodity> userOptional = Optional.ofNullable(commodityDao.getOneById(commodity.getComId()));
            if(userOptional.isPresent()){
                BeanUtils.copyProperties(commodity,userOptional.get(),nullProperties);
                commodity = userOptional.get();
            }
        }
        return commodityDao.save(commodity);
    }

    @Override
    public void delete(Integer id) {
        commodityDao.delete(id);
    }
    @Override
    public Optional<Commodity> getCommodityById(Integer id) {
        return Optional.ofNullable(commodityDao.getOneById(id));
    }

    @Override
    public List<Commodity> getCommoditiesByType(Integer classify) {
        return commodityDao.getSomeByType(classify);
    }
}
