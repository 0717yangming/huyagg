package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.Comments;

import java.util.List;

public interface CommentsService {
    List<Comments> getAllByCommodityId(Integer commodityId);
    Integer save(Comments comments);
    boolean delete(Integer commentsId);
}
