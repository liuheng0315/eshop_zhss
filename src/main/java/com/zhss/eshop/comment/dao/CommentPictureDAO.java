package com.zhss.eshop.comment.dao;

import com.zhss.eshop.comment.domain.CommentPictureDO;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-05-10 19:23
 **/
public interface CommentPictureDAO {
    /**
     * 新增评论晒图
     *
     * @param commentPictureDO 评论晒图DO对象
     */
    void saveCommentPicture(CommentPictureDO commentPictureDO);
}
