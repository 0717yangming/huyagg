package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Commodity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommodityDao {
    List<Commodity> queryAll();
    Commodity getOneById(Integer id);
    List<Commodity> getSomeByType(Integer classify);
    Integer save(Commodity commodity);
    boolean update(Commodity commodity);
    void delete(Integer id);
}
