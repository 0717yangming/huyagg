package com.ym.hygg.huyagg.controller;


import com.ym.hygg.huyagg.annotation.PassToken;
import com.ym.hygg.huyagg.annotation.UserLoginToken;
import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.service.CommodityService;
import com.ym.hygg.huyagg.utils.ImageUploadUtils;
import lombok.extern.slf4j.Slf4j;
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
    @PassToken
    @GetMapping
    public List<Commodity> queryAll(){
       log.info("获取所有商品");
        return commodityService.queryAllCommodity();
    }
    @PassToken
    @GetMapping("/{id}")
    public Commodity getCommodityById(@PathVariable Integer id){
        Optional<Commodity> optional = commodityService.getCommodityById(id);
        return optional.get();
    }
    @GetMapping("/classify/{id}")
    public List<Commodity> getCommoditiesByType(@PathVariable Integer id){
        return commodityService.getCommoditiesByType(id);
    }

    /**
     * 发布商品
     * @param commodity
     * @param multipartFile
     * @return
     */
    @UserLoginToken
    @PostMapping
    public Map<String,Object> save(@NotNull Commodity commodity,@Nullable @RequestParam("image") MultipartFile multipartFile){
        commodity.setReleaseTime(new Date(System.currentTimeMillis()));
        Map<String,Object> map = null;
        if(multipartFile!=null && multipartFile.getSize() > 0 ){
            map = ImageUploadUtils.uploadImage(multipartFile, commodity.getPicName());
        String imageName = (String)map.get("newName");
        commodity.setPicName(imageName);
        }
        Integer save = commodityService.save(commodity);
        if(map == null)
            map = new HashMap<>();
        if(save != null){
            map.put("code",200);
            map.put("object",save);
        }else {
            map.put("code",301);
        }
        System.out.println("添加"+commodity);
        return map;
    }
    @UserLoginToken
    @PutMapping
    public Map<String, Object> update(@RequestBody Commodity commodity,@Nullable @RequestParam("image") MultipartFile multipartFile){
        Map<String,Object> map = null;
        if(multipartFile.getSize() > 0){
            map = ImageUploadUtils.uploadImage(multipartFile, commodity.getPicName());
            String imageName = (String)map.get("newName");
            commodity.setPicName(imageName);
        }
        System.out.println("修改"+commodity);
        Integer save = commodityService.save(commodity);
        if(save != null){
            map.put("code",200);
            map.put("object",save);
        }else {
            map.put("code",301);
            map.put("object",null);
        }
        return map;
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
    /*
    图片上传
     */
    @UserLoginToken
    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("fileName")MultipartFile file){
        String result_msg = "";
        Map<String,Object> root=new HashMap<String, Object>();
        if(file.getSize()/1000>100){
            result_msg = "图片大小不能超过100kb";
        }
        else{
            String fileType = file.getContentType();
            if(fileType.equals("image/jpeg") || fileType.equals("image/png") || fileType.equals("image/jpg")){
               // String localPath = "E:\\IdeaProjects\\huyagg\\target\\classes\\static\\images";
                //String localPath = "E:\\IdeaProjects\\huyagg\\src\\main\\resources\\static\\images\\";
                String localPath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\";
                String fileName = file.getOriginalFilename();
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                fileName = UUID.randomUUID()+suffixName;
                File newfile = new File(localPath + fileName );
                if (!newfile.getParentFile().exists())
                {
                    System.out.println("mkdirs");
                    newfile.getParentFile().mkdirs();
                }
                String relativePath="images/"+fileName;
                root.put("relativePath",relativePath);//前端根据是否存在该字段来判断上传是否成功
                result_msg="图片上传成功";
                try{
                    file.transferTo(newfile);

                }catch (IOException e){
                    e.printStackTrace();
                    result_msg="图片上传失败";
                }
            }
        }
             root.put("result_msg",result_msg);
            return root;
    }
}
