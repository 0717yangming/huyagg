package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.dao.OrdersDao;
import com.ym.hygg.huyagg.pojo.Orders;
import com.ym.hygg.huyagg.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;
    @Override
    public Integer save(Orders orders) {
        return  ordersDao.save(orders);
    }

    @Override
    public boolean update(Orders orders) {
        return ordersDao.update(orders);
    }

    @Override
    public Optional<Orders> findBySerial(Long serial) {
        return Optional.ofNullable(ordersDao.findBySerial(serial));
    }

    @Override
    public List<Orders> findAllByUserId(Integer uid) {
        return ordersDao.findAllByUserId(uid);
    }

    @Override
    public void deleteBySerial(Long serial) {
         ordersDao.deleteBySerial(serial);
    }
}
