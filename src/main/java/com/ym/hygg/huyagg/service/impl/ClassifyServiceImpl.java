package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.common.CommonUtils;
import com.ym.hygg.huyagg.dao.ClassifyDao;
import com.ym.hygg.huyagg.pojo.Classify;
import com.ym.hygg.huyagg.service.ClassifyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Resource
    private ClassifyDao classifyDao;

    @Override
    public Integer save(Classify classify) {
        return classifyDao.save(classify);
    }

    @Override
    public List<Classify> AllClassifies() {
        return classifyDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        classifyDao.deleteById(id);
    }
}
