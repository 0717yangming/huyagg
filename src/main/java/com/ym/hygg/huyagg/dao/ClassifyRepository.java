package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Classify;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassifyRepository extends JpaRepository<Classify,Integer>, JpaSpecificationExecutor<Classify> {
}
