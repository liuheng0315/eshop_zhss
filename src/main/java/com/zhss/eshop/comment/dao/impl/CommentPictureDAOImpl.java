package com.zhss.eshop.comment.dao.impl;

import com.zhss.eshop.comment.dao.CommentPictureDAO;
import com.zhss.eshop.comment.domain.CommentPictureDO;
import com.zhss.eshop.comment.mapper.CommentPictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-05-10 19:24
 **/
@Repository
public class CommentPictureDAOImpl implements CommentPictureDAO {
    @Autowired
    private CommentPictureMapper commentPictureMapper;
    /**
     * 新增评论晒图
     *
     * @param commentPictureDO 评论晒图DO对象
     */
    @Override
    public void saveCommentPicture(CommentPictureDO commentPictureDO) {
        commentPictureMapper.saveCommentPicture(commentPictureDO);
    }
}
