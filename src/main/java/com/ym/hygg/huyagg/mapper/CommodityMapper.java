package com.ym.hygg.huyagg.mapper;

import com.ym.hygg.huyagg.pojo.Commodity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommodityMapper {

    List<Commodity> getAllCommodities();

    @Select("SELECT * FROM commodity where id = #{id}")
    Commodity GetCommodityById(Integer id);

    @Select("SELECT * FROM commodity where classify = #{classify}")
    List<Commodity> getCommoditiesByType(Integer classify);

    int save(Commodity commodity);

    int updateByExample(Commodity commodity);

    @Delete("DELETE FROM commodity where id = #{id}")
    int delete(Integer id);

}
