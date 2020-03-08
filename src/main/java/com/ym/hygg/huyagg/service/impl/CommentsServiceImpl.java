package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.dao.CommentsRepository;
import com.ym.hygg.huyagg.pojo.Comments;
import com.ym.hygg.huyagg.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;
    @Override
    public List<Comments> allCommentsByCommodityId(Integer commodityId) {
        return commentsRepository.ByCommodityId(commodityId);
    }
}
