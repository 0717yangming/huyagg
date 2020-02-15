package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.mapper.Tb1Mapper;
import com.ym.hygg.huyagg.pojo.Tb1;
import com.ym.hygg.huyagg.service.Tb1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tb1ServiceImpl implements Tb1Service {
    @Autowired
    private Tb1Mapper tb1Mapper;
    @Override
    public List<Tb1> getAll() {
        return tb1Mapper.getAll();
    }
}
