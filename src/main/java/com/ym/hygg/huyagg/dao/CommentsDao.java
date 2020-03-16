package com.ym.hygg.huyagg.dao;

import com.ym.hygg.huyagg.pojo.Comments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentsDao {
    List<Comments> getAllByCommodityId(Integer commodityId);
    Integer save(Comments comments);
    boolean delete(Integer commentsId);
}
