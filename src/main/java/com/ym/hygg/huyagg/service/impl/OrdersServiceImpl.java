package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.dao.OrdersRepository;
import com.ym.hygg.huyagg.pojo.Orders;
import com.ym.hygg.huyagg.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersRepository ordersRepository;
    @Override
    public Orders save(Orders orders) {
        final Orders save = ordersRepository.save(orders);
        return save;
    }

    @Override
    public Optional<Orders> findBySerial(Long serial) {
        return ordersRepository.findById(serial);
    }

    @Override
    public List<Orders> findAllByUserId(Integer uid) {
        return ordersRepository.findByUser(uid);
    }

    @Override
    public void deleteBySerial(Long serial) {
         ordersRepository.deleteById(serial);
    }
}
