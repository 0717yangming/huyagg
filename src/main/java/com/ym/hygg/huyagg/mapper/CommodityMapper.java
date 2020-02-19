package com.ym.hygg.huyagg.mapper;

import com.ym.hygg.huyagg.pojo.Commodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommodityMapper {

    List<Commodity> getAllCommodities();

    int save(Commodity commodity);

    int updateByExample(Commodity commodity);

    @Delete("DELETE FROM commodity where id = #{id}")
    int delete(Integer id);

}
