package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer>, JpaSpecificationExecutor<Comments> {
}
