package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer>, JpaSpecificationExecutor<Comments> {
    @Query("from Comments where  commodityDetails.id = ?1")
    List<Comments> ByCommodityId(Integer commodityDetailsId);
}
