package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.common.CommonUtils;
import com.ym.hygg.huyagg.dao.ClassifyRepository;
import com.ym.hygg.huyagg.pojo.Classify;
import com.ym.hygg.huyagg.service.ClassifyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassifyServiceImpl implements ClassifyService {
    @Autowired
    private ClassifyRepository classifyRepository;

    @Override
    public Classify save(Classify classify) {
        if(classify.getClassId()!=null){
            Optional<Classify> optionalClassify = classifyRepository.findById(classify.getClassId());
            if(optionalClassify.isPresent()){
                String[] nullProperties = CommonUtils.getNullProperties(classify);
                BeanUtils.copyProperties(classify,optionalClassify.get(),nullProperties);
                classify = optionalClassify.get();
            }
        }
        return classifyRepository.save(classify);
    }

    @Override
    public List<Classify> AllClassifies() {
        return classifyRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
       classifyRepository.deleteById(id);
    }
}
