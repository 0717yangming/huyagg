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
    public List<Commodity> queryAllCommodity(Integer distinguish) {
        //List<Commodity> commodities = commodityMapper.commodityWithAudited();
       //Integer distinguish = 1;
        return commodityDao.queryAll(distinguish);
    }

    @Override
    public List<Commodity> getSelf(Integer uid, Integer distinguish) {
        return commodityDao.getSelf(uid, distinguish);
    }
    @Override
    public Integer save(Commodity commodity) {
        commodityDao.save(commodity);
        return commodity.getComId();
    }

    @Override
    public Integer update(Commodity commodity) {
        return commodityDao.update(commodity);
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
