package com.zhss.eshop.comment.service;

import com.zhss.eshop.comment.domain.CommentInfoDTO;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-05-06 23:38
 **/
public interface CommentInfoService {
    /**
     * 插入评论信息
     *
     * @param commentInfoDTO 评论信息对象
     * @return 处理结果
     */
    Boolean saveCommentInfo(CommentInfoDTO commentInfoDTO);
}
