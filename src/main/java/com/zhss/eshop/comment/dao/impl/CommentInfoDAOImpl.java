package com.zhss.eshop.comment.dao.impl;

import com.zhss.eshop.comment.dao.CommentInfoDAO;
import com.zhss.eshop.comment.domain.CommentInfoDO;
import com.zhss.eshop.comment.mapper.CommentInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-05-06 23:33
 **/
@Slf4j
@Repository
public class CommentInfoDAOImpl implements CommentInfoDAO {
    @Autowired
    private CommentInfoMapper commentInfoMapper;


    @Override
    public Boolean saveCommentInfo(CommentInfoDO commentInfoDO) {
        try {
            commentInfoMapper.saveCommentInfo(commentInfoDO);
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
        return true;
    }
}
