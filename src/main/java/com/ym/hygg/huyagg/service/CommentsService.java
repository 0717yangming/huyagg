package com.ym.hygg.huyagg.service;

import com.ym.hygg.huyagg.pojo.Comments;

import java.util.List;

public interface CommentsService {
    List<Comments> allCommentsByCommodityId(Integer commodityId);
}
