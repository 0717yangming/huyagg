package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommodityDao {
    /**
     * 浏览所有卖家或买家发布的已审核的商品信息
     */
    List<Commodity> queryAll(Integer distinguish);

    /**
     * 得到自己发布的需求信息或发布的商品
     * 0 代表买家的需求
     * 1 代表卖家发布的商品
     */
    List<Commodity> getSelf(@Param("uid") Integer uid, @Param("distinguish") Integer distinguish);

    /**
     * 根据商品id查询商品
     */
    Commodity getOneById(Integer id);

    /**
     * 根据类型查询
     */
    List<Commodity> getSomeByType(Integer classify);
    /*
        保存商品
     */
    Integer save(Commodity commodity);

    /**
     * 修改商品的信息
     */
    Integer update(Commodity commodity);

    void delete(Integer id);
}
