package com.zhss.eshop.comment.dao;

import com.zhss.eshop.comment.domain.CommentInfoDO;

/**
 * @author : liu heng
 * @description : 评论信息组件的DAO接口
 * @date : 2021-05-06 23:30
 **/
public interface CommentInfoDAO {
    /**
     * 插入评论信息
     * @param commentInfoDO 评论信息对象
     * @return 处理结果
     */
    Boolean saveCommentInfo(CommentInfoDO commentInfoDO);
}
