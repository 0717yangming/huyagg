package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommodityRepository extends JpaRepository<Commodity,Integer>, JpaSpecificationExecutor<Commodity> {
    @Query(value = "from Commodity where classId = ?1")
    List<Commodity> getCommoditiesByType(Integer id);
}
