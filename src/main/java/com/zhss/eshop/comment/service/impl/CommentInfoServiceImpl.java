package com.zhss.eshop.comment.service.impl;

import com.zhss.eshop.comment.constant.CommentInfoScore;
import com.zhss.eshop.comment.constant.CommentStatus;
import com.zhss.eshop.comment.constant.CommentType;
import com.zhss.eshop.comment.constant.DefaultComment;
import com.zhss.eshop.comment.dao.CommentInfoDAO;
import com.zhss.eshop.comment.domain.CommentInfoDO;
import com.zhss.eshop.comment.domain.CommentInfoDTO;
import com.zhss.eshop.comment.service.CommentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author : liu heng
 * @description : 评论信息service
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
            // 计算评论的总分数
            Integer totalScore = Math.round((commentInfoDTO.getGoodsScore()
                    + commentInfoDTO.getCustomerServiceScore()
                    + commentInfoDTO.getLogisticsScore()) / 3);
            commentInfoDTO.setTotalScore(totalScore);

            // 设置是否为默认评论
            commentInfoDTO.setIsDefaultComment(DefaultComment.NO);

            // 设置评论的状态
            commentInfoDTO.setCommentStatus(CommentStatus.APPROVING);

            // 设置评论的类型
            Integer commentType = 0;
            if(totalScore >= CommentInfoScore.FOUR) {
                commentType = CommentType.GOOD_COMMENT;
            } else if(totalScore.equals(CommentInfoScore.THREE)) {
                commentType = CommentType.MEDIUM_COMMENT;
            } else if(totalScore > CommentInfoScore.ZERO && totalScore <= CommentInfoScore.TWO) {
                commentType = CommentType.BAD_COMMENT;
            }

            commentInfoDTO.setCommentType(commentType);

            // 设置创建时间和修改时间
            commentInfoDTO.setGmtCreate(new Date());
            commentInfoDTO.setGmtModified(new Date());

            // 将评论信息保存到数据库中去
            CommentInfoDO commentInfoDO = commentInfoDTO.clone(CommentInfoDO.class);
            commentInfoDAO.saveCommentInfo(commentInfoDO);

            // 设置评论信息的id
            commentInfoDTO.setId(commentInfoDO.getId());
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
        return true;
    }
}
