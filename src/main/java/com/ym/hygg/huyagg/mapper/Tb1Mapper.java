package com.ym.hygg.huyagg.mapper;

import com.ym.hygg.huyagg.pojo.Tb1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Tb1Mapper {
    @Select("select * from tb1")
     List<Tb1> getAll();
}
