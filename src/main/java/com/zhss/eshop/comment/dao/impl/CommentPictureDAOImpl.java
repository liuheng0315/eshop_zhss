package com.zhss.eshop.comment.dao.impl;

import com.zhss.eshop.comment.dao.CommentPictureDAO;
import com.zhss.eshop.comment.domain.CommentPictureDO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-05-10 19:24
 **/
public class CommentPictureDAOImpl implements CommentPictureDAO {
    @Autowired
    private CommentPictureDAO commentPictureDAO;
    /**
     * 新增评论晒图
     *
     * @param commentPictureDO 评论晒图DO对象
     */
    @Override
    public void saveCommentPicture(CommentPictureDO commentPictureDO) {
        commentPictureDAO.saveCommentPicture(commentPictureDO);
    }
}
