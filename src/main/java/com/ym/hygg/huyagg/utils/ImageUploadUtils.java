package com.ym.hygg.huyagg.utils;

import com.ym.hygg.huyagg.pojo.Commodity;
import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.service.CommodityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.util.calendar.LocalGregorianCalendar;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
@Slf4j
@Component
public class ImageUploadUtils {
    @Resource
    private CommodityService commodityService;
    public Map<String,Object> uploadImage(MultipartFile file, Integer comId){
        Optional<Commodity> commodityOptional = commodityService.getCommodityById(comId);
        if(!commodityOptional.isPresent() | file.getSize() <= 0){
            return null;
        }
        Map<String,Object> map = new HashMap<>();
        String fileType = file.getContentType();
        String msg = "";
        if(fileType.equals("image/jpg") || fileType.equals("image/png") || fileType.equals("image/jpeg")){
            String filename = file.getOriginalFilename();
            String suffixName = filename.substring(filename.lastIndexOf("."));
            String newName = UUID.randomUUID() + suffixName;
            String relativeName = "images/"+newName;
           URL resource = ClassUtils.getDefaultClassLoader().getResource("static/images");
           log.info("DEBUG--->"+resource);
            if(resource == null) {
                File file1 = new File(ClassUtils.getDefaultClassLoader().getResource("static").getPath()+"/images");
                log.info(ClassUtils.getDefaultClassLoader().getResource("static")+"/images");
               if(file1.mkdir()){
                   log.info("创建目录images");
                   resource =  ClassUtils.getDefaultClassLoader().getResource("static/images");
               }
            }
            String newPath = resource.getPath();
            try {
                File file1 = new File(newPath+"/"+newName);
                file.transferTo(file1);
                msg = "图片上传成功";
                map.put("msg",msg);
                map.put("code", ResponseObject.SUCCESS);
                Commodity commodity = commodityOptional.get();
                if(commodity.getPicName() != null && !commodity.getPicName().equals("")){
                    file1 = new File(newPath+"/"+commodity.getPicName());
                    if (file1.exists()){
                        log.info("图片存在可删除");
                        boolean rt = file1.delete();
                        log.info("DEBUG----删除图片--"+rt);
                    }

                }
                commodity.setPicName(newName);
                commodityService.update(commodity);
                return map;
            } catch (IOException e) {
                e.printStackTrace();
                msg = "图片上传失败";
                map.put("msg",msg);
                map.put("code", ResponseObject.Fail);
                return map;
            }
        }else{
            msg = "非图片类型（jpg/png/jpeg）";
            map.put("msg",msg);
            map.put("code", ResponseObject.Fail);
            return map;
        }
    }
}
