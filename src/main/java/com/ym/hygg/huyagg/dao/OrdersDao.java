package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Orders;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface OrdersDao {
    Integer save(Orders orders);
    boolean update(Orders orders);
    Orders findBySerial(Long serial);
    List<Orders> findAllByUserId(Integer uid);
    void deleteBySerial(Long serial);
}
