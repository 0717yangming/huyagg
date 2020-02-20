package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.service.CommodityService;
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

@CrossOrigin
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    @GetMapping
    public List<Commodity> queryAll(){
        System.out.println("访问了allCommodities");
        return commodityService.queryAllCommodity();
    }
    @GetMapping("/{id}")
    public Commodity getCommodityById(@PathVariable Integer id){
        return commodityService.getCommodityById(id);
    }
    @GetMapping("/classify/{id}")
    public List<Commodity> getCommoditiesByType(@PathVariable Integer id){
        return commodityService.getCommoditiesByType(id);
    }
    @PostMapping
    public ResponseObject save(@RequestBody @NotNull Commodity commodity){
        commodity.setAddTime(new Date(System.currentTimeMillis()));
        System.out.println("添加"+commodity);
       int i = commodityService.save(commodity);
        System.out.println("添加了"+i+"件商品");
        return new ResponseObject(200,"添加成功");
    }
    @PutMapping
    public ResponseObject update(@RequestBody Commodity commodity){
        System.out.println("修改"+commodity);
        int i = commodityService.update(commodity);
        System.out.println("修改了"+i+"条记录");
        return new ResponseObject(200,"修改成功");
    }
    @DeleteMapping("/{id}")
    public ResponseObject delete(@PathVariable Integer id){
        int i = commodityService.delete(id);
        return new ResponseObject(200,"删除成功");
    }
    /*
    图片上传
     */
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
    @PostMapping("/image")
    public Map<String,Object> singleFileUpload(@RequestParam("image") MultipartFile file) {
            Map<String,Object> map = new HashMap<>();
                String relpath = System.getProperty("user.dir");
                map.put("relpath",relpath);
                return map;
    }


}
