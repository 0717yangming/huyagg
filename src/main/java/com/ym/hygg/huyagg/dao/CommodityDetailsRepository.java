package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.CommodityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDetailsRepository extends JpaRepository<CommodityDetails,Integer>, JpaSpecificationExecutor<CommodityDetails> {

}
