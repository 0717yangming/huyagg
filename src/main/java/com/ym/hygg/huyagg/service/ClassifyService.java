package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.Classify;

import java.util.List;

public interface ClassifyService {
    Integer save(Classify classify);
    List<Classify> AllClassifies();
    void deleteById(Integer id);
}
