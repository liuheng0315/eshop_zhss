package com.zhss.eshop.comment.service.impl;

import com.zhss.eshop.comment.dao.CommentInfoDAO;
import com.zhss.eshop.comment.domain.CommentInfoDO;
import com.zhss.eshop.comment.domain.CommentInfoDTO;
import com.zhss.eshop.comment.service.CommentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-05-06 23:39
 **/
@Service
@Slf4j
public class CommentInfoServiceImpl implements CommentInfoService {
    @Autowired
    private CommentInfoDAO commentInfoDAO;

    /**
     * 插入评论信息
     *
     * @param commentInfoDTO 评论信息对象
     * @return 处理结果
     */
    @Override
    public Boolean saveCommentInfo(CommentInfoDTO commentInfoDTO) {
        try {
            // 对评论信息进行处理

            // 将评论信息保存到数据库中
            commentInfoDAO.saveCommentInfo(commentInfoDTO.clone(CommentInfoDO.class));
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
        return true;
    }
}
