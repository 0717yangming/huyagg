package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.mapper.ClassifyMapper;
import com.ym.hygg.huyagg.pojo.Classify;
import com.ym.hygg.huyagg.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyMapper classifyMapper;
    @Override
    public List<Classify> AllClassifies() {
        return classifyMapper.getAll();
    }
}
