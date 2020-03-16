package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.pojo.CommodityDetails;
import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.service.CommodityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/details")
public class CommodityDetailsController {
    @Resource
    private CommodityDetailsService commodityDetailsService;
    @GetMapping
    public ResponseObject getCommodityDetails(String cdId){
        ResponseObject ro = new ResponseObject();
        try {
            CommodityDetails commodityDetails = commodityDetailsService.geoOneById(Integer.parseInt(cdId));
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("商品详情");
            ro.setObject(commodityDetails);
            return ro;
        }catch (Exception ex){
            ro.setCode(ResponseObject.Fail);
            ro.setMsg("查询失败。。");
            return ro;
        }
    }

}
