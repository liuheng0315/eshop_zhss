package com.zhss.eshop.comment.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description : 评论的聚合统计信息
 * @date : 2021-05-06 22:34
 **/
@Data
public class CommentAggregate {
    /**
     * id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 总评论数
     */
    private Long totalCommentCount;
    /**
     * 好评数
     */
    private Long goodCommentCount;
    /**
     * 好评比例
     */
    private Double goodCommentRate;
    /**
     * 晒图评论数量
     */
    private Long showPicturesCommentCount;
    /**
     * 中评数量
     */
    private Long mediumCommentCount;
    /**
     * 差评数量
     */
    private Long badCommentCount;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
