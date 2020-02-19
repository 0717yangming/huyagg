package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping("/allCommodities")
    public List<Commodity> queryAll(){
        System.out.println("访问了allCommodities");
        return commodityService.queryAllCommodity();
    }
    @PostMapping("/save")
    public String save(@RequestBody @NotNull Commodity commodity){
        commodity.setAddTime(new Date(System.currentTimeMillis()));
        System.out.println("添加"+commodity);
       int i = commodityService.save(commodity);
        System.out.println("添加了"+i+"件商品");
        return "插入成功";
    }
    @PutMapping("/putCommodity")
    public String update(@RequestBody Commodity commodity){
        System.out.println("修改"+commodity);
        int i = commodityService.update(commodity);
        System.out.println("修改了"+i+"条记录");
        return "修改成功";
    }
}
