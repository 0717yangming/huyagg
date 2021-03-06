package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersService {
    Integer save(Orders orders);
    boolean update(Orders orders);
    Optional<Orders> findBySerial(Long serial);
    List<Orders> findAllByUserId(Integer uid);
    void deleteBySerial(Long serial);
}
