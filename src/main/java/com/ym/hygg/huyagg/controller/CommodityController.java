package com.ym.hygg.huyagg.controller;


import com.ym.hygg.huyagg.annotation.PassToken;
import com.ym.hygg.huyagg.annotation.UserLoginToken;
import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.service.CommodityService;
import com.ym.hygg.huyagg.utils.ImageUploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Resource
    private CommodityService commodityService;

    @Resource
    private ImageUploadUtils uploadUtils;

    /**
     * 查询所有商品
     * 根据distinguish的值来决定查询
     * 1 代表查询的时所有卖家发布的商品
     * 0 代表查询的是所有买家发布的需求
     */
    @PassToken
    @GetMapping("/{distinguish}")
    public ResponseObject queryAll(@PathVariable Integer distinguish){
        ResponseObject ro = new ResponseObject();
       log.info("获取所有商品");
       String msg = (distinguish == 1) ? "查询需求" : "查询商品";
        List<Commodity> commodities = commodityService.queryAllCommodity(distinguish);
        log.info("DEBUG 看看数据库没有返回数据 数组时怎么呀的："+commodities);
        if(commodities != null && commodities.size()>0){
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg(msg + "成功！");
            ro.setObject(commodities);
        }else {
            ro.setCode(ResponseObject.Fail);
            ro.setMsg(msg + "失败！");
        }
        return ro;
    }
    @PassToken
    @GetMapping("/{id}")
    public ResponseObject getCommodityById(@PathVariable Integer id){
        Optional<Commodity> optional = commodityService.getCommodityById(id);
        ResponseObject ro = new ResponseObject(ResponseObject.Fail, "该商品id查询为空！");
        if(optional.isPresent()){
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("查询成功！");
            ro.setObject(optional.get());
        }
        return ro;
    }
    @GetMapping("/classify/{id}")
    public ResponseObject getCommoditiesByType(@PathVariable Integer id){
        ResponseObject ro = new ResponseObject(ResponseObject.Fail, "无该分类的商品！");
        List<Commodity> commodities = commodityService.getCommoditiesByType(id);
        if(commodities != null && commodities.size() > 0){
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("查询成功！");
            ro.setObject(commodities);
        }
        return ro;
    }

    /**
     * 发布商品
     */
    @UserLoginToken
    @PostMapping
    public ResponseObject save(@RequestBody Commodity commodity){
        commodity.setReleaseTime(new Date(System.currentTimeMillis()));
        Optional<Integer> save = Optional.ofNullable(commodityService.save(commodity));
        ResponseObject ro = new ResponseObject(ResponseObject.Fail,"保存失败！");
        if(save.isPresent()){
            log.info("添加商品："+save.get());
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("保存成功!");
            ro.setObject(save.get());
        }
        return ro;
    }

    @PostMapping("/upload")
    public ResponseObject uploadImage(@RequestParam("comId") Integer comId, @RequestParam("image") MultipartFile multipartFile){
        Map<String, Object> map = uploadUtils.uploadImage(multipartFile, comId);
        ResponseObject ro = new ResponseObject(ResponseObject.Reject,"无法访问！");
        if(map != null){
            Integer code = (Integer) map.get("code");
            String msg = (String)map.get("msg");
            ro.setMsg(msg);
            ro.setCode(code);
            return ro;
        }
        return ro;
    }
    @UserLoginToken
    @PutMapping
    public ResponseObject update(@RequestBody Commodity commodity){
        ResponseObject ro = new ResponseObject(ResponseObject.Fail,"保存失败");
        Optional<Integer> save = Optional.ofNullable(commodityService.update(commodity));
        if (save.isPresent()){
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("修改成功!");
            ro.setObject(save.get());
        }
        return ro;
    }
    @UserLoginToken
    @GetMapping("/self")
    public ResponseObject self(@RequestParam("uid") Integer uid, @RequestParam("distinguish") Integer distinguish){
        List<Commodity> self = commodityService.getSelf(uid, distinguish);
        ResponseObject ro = new ResponseObject(ResponseObject.SUCCESS,"查询成功！");
        ro.setObject(self);
        return ro;

    }
    @UserLoginToken
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        try {
            commodityService.delete(id);
            return new ResponseObject(ResponseObject.SUCCESS,"删除成功",null,null);
        }catch (Exception ex){
            return new ResponseObject(ResponseObject.Fail,"删除失败",null,null);
        }

    }


}
