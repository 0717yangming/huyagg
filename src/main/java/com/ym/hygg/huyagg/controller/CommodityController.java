package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.annotation.PassToken;
import com.ym.hygg.huyagg.annotation.UserLoginToken;
import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.service.CommodityService;
import com.ym.hygg.huyagg.utils.ImageUploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
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
        return commodityService.getCommodityById(id);
    }
    @GetMapping("/classify/{id}")
    public List<Commodity> getCommoditiesByType(@PathVariable Integer id){
        return commodityService.getCommoditiesByType(id);
    }
    @UserLoginToken
    @PostMapping
    public Map<String,Object> save(@NotNull Commodity commodity,@RequestParam("image") MultipartFile multipartFile){
        commodity.setAddTime(new Date(System.currentTimeMillis()));
        Map<String,Object> map = null;
        if(multipartFile.getSize() > 0){
            map = ImageUploadUtils.uploadImage(multipartFile);
        String imageName = (String)map.get("newName");
        commodity.setPicName(imageName);
        }
       int i = commodityService.save(commodity);
        if(i > 0){
            map.put("code",200);
        }else {
            map.put("code",301);
        }
        System.out.println("添加"+commodity);
        System.out.println("添加了"+i+"件商品");
        return map;
    }
    @UserLoginToken
    @PutMapping
    public Map<String, Object> update(@RequestBody Commodity commodity, @RequestParam("image") MultipartFile multipartFile){
        Map<String,Object> map = null;
        if(multipartFile.getSize() > 0){
            map = ImageUploadUtils.uploadImage(multipartFile);
            String imageName = (String)map.get("newName");
            commodity.setPicName(imageName);
        }
        System.out.println("修改"+commodity);
        int i = commodityService.update(commodity);
        if(i > 0){
            map.put("code",200);
        }else {
            map.put("code",301);
        }
        System.out.println("修改了"+i+"条记录");
        return map;
    }
    @UserLoginToken
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        int i = commodityService.delete(id);
        return new ResponseObject(200,"删除成功");
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
    @UserLoginToken
    @PostMapping("/image")
    public Map<String,Object> singleFileUpload(@RequestParam("image") MultipartFile file) {
            Map<String,Object> map = new HashMap<>();
                String relpath = System.getProperty("user.dir");
                map.put("relpath",relpath);
                return map;
    }


}
