package com.ym.hygg.huyagg.service.impl;

import com.ym.hygg.huyagg.dao.CommentsDao;
import com.ym.hygg.huyagg.pojo.Comments;
import com.ym.hygg.huyagg.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class CommentsServiceImpl implements CommentsService {
    @Resource
    private CommentsDao commentsDao;

    @Override
    public List<Comments> getAllByCommodityId(Integer commodityId) {
        return commentsDao.getAllByCommodityId(commodityId);
    }

    @Override
    public Integer save(Comments comments) {
        return commentsDao.save(comments);
    }

    @Override
    public boolean delete(Integer commentsId) {
        return commentsDao.delete(commentsId);
    }
}
