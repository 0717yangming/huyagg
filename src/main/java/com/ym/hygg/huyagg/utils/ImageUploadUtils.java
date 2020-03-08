package com.ym.hygg.huyagg.utils;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ImageUploadUtils {

    public static Map<String,Object> uploadImage(MultipartFile file, String oldImage){
        Map<String,Object> map = new HashMap<>();
        String fileType = file.getContentType();
        String msg = "";
        if(fileType.equals("image/jpg") || fileType.equals("image/png") || fileType.equals("image/jpeg")){
            String filename = file.getOriginalFilename();
            String suffixName = filename.substring(filename.lastIndexOf("."));
            String newName = UUID.randomUUID() + suffixName;
            String relativeName = "images/"+newName;
            map.put("relativeName",relativeName);
            String newPath = ClassUtils.getDefaultClassLoader().getResource("static/images").getPath();
            System.out.println("newPath:"+newPath);
            try {
                File file1 = new File(newPath+"/"+newName);
                file.transferTo(file1);
                msg = "图片上传成功";
                map.put("msg",msg);
                map.put("newName",newName);
                if(oldImage != null && !oldImage.equals("")){
                    file1 = new File(newPath+"/"+oldImage);
                    System.out.println(newPath+"/"+oldImage);
                    if (file1.exists()){
                        System.out.println("图片存在可删除");
                        boolean rt = file1.delete();
                        System.out.println("DEBUG----删除图片--"+rt);
                    }

                }
                return map;
            } catch (IOException e) {
                e.printStackTrace();
                msg = "图片上传失败";
                map.put("msg",msg);
                return map;
            }
        }else{
            msg = "非图片类型（jpg/png/jpeg）";
            map.put("msg",msg);
            return map;
        }
    }
}
