package com.ym.hygg.huyagg.mapper;

import com.ym.hygg.huyagg.pojo.Classify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassifyMapper {
    @Select("SELECT * FROM classify")
    List<Classify> getAll();
    @Select("SELECT * FROM classify WHERE classId = #{id}")
    Classify queryByById(Integer id);

}
