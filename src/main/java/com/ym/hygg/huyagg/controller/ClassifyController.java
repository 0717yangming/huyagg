package com.ym.hygg.huyagg.controller;


import com.ym.hygg.huyagg.pojo.Classify;
import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/classify")
public class ClassifyController {
    @Resource
    private ClassifyService classifyService;
    @GetMapping
    public ResponseObject allClassify(){
        ResponseObject responseObject = new ResponseObject();
        List<Classify> classifies = classifyService.AllClassifies();
        if(classifies != null){
            responseObject.setObject(classifies);
            responseObject.setMsg("所有商品类型");
            responseObject.setCode(ResponseObject.SUCCESS);
            return responseObject;
        }else{
            responseObject.setObject(null);
            responseObject.setMsg("查询所有商品类型失败!!!");
            responseObject.setCode(ResponseObject.Fail);
            return responseObject;
        }
    }
}
