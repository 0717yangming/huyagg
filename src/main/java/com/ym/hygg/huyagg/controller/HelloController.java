package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.mapper.Tb1Mapper;
import com.ym.hygg.huyagg.pojo.Tb1;
import com.ym.hygg.huyagg.service.Tb1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HelloController {
    @Autowired
    private Tb1Service tb1Service;
    @GetMapping("/hello")
    public String sayHello(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        model.addAttribute("name", name);
        return "hello";
    }
    @GetMapping("/sayHello")
    public @ResponseBody List<Tb1> sayHello(@RequestParam String say){
        System.out.println(say);
        return tb1Service.getAll();
    }
}
