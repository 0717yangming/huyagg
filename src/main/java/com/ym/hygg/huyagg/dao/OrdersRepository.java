package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long>, JpaSpecificationExecutor<Long> {
    @Query("from Orders where user.uid = ?1")
    public List<Orders> findByUser(Integer uid);
}
