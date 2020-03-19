package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommodityService {
    /**
     * 浏览所有卖家或买家发布的已审核的商品信息
     */
    List<Commodity> queryAllCommodity(Integer distinguish);
    /**
     * 得到自己发布的需求信息或发布的商品
     * 0 代表买家的需求
     * 1 代表卖家发布的商品
     */
    List<Commodity> getSelf(Integer uid, Integer distinguish);
    /**
     * 根据商品id查询商品
     */
    Optional<Commodity> getCommodityById(Integer id);
    /**
     * 根据类型查询
     */
    List<Commodity> getCommoditiesByType(Integer classify);
    /*
        保存商品
     */
    Integer save(Commodity commodity);
    /**
     * 根据商品id删除对应的商品
     */
    void delete(Integer id);

    /**
     * 修改商品信息
     */
    Integer update(Commodity commodity);
}
