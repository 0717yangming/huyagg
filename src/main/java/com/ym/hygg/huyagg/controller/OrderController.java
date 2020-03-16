package com.ym.hygg.huyagg.controller;

import com.ym.hygg.huyagg.pojo.Orders;
import com.ym.hygg.huyagg.pojo.ResponseObject;
import com.ym.hygg.huyagg.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Resource
    private OrdersService ordersService;

    @PostMapping
    public ResponseObject save(@RequestBody Orders orders){
        Integer save = ordersService.save(orders);
        ResponseObject ro = new ResponseObject();
        ro.setCode(ResponseObject.SUCCESS);
        ro.setMsg("订单添加成功");
        ro.setObject(save);
        return ro;
    }
    @GetMapping("/serial")
    public ResponseObject findBySerial(@RequestParam("serial") Long serial){
        Optional<Orders> optionalOrders = ordersService.findBySerial(serial);
        ResponseObject ro = new ResponseObject();
        if(optionalOrders.isPresent()){
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("订单查询成功");
            ro.setObject(optionalOrders.get());
        }else{
            ro.setCode(ResponseObject.Fail);
            ro.setMsg("订单查询不存在！");
        }
        return ro;
    }
    @GetMapping("/user")
    public ResponseObject findAllByUserId(@RequestParam("uid") Integer uid){
        List<Orders> ordersList = ordersService.findAllByUserId(uid);
        ResponseObject ro = new ResponseObject();
        if(ordersList!=null){
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("订单查询成功");
            ro.setObject(ordersList);
        }else{
            ro.setCode(ResponseObject.Fail);
            ro.setMsg("订单查询不存在！");
        }
        return ro;
    }
    @DeleteMapping
    public ResponseObject deleteBySerial(Long serial){
        ordersService.deleteBySerial(serial);
        ResponseObject ro = new ResponseObject();
            ro.setCode(ResponseObject.SUCCESS);
            ro.setMsg("订单查询成功");
            return ro;
    }
}
