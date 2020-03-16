package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Classify;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassifyDao {
    Integer save(Classify classify);
    boolean update(Classify classify);
    List<Classify> findAll();
    void deleteById(Integer id);
}
