package com.zhss.eshop.comment.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description : 评论信息
 * @date : 2021-05-06 22:18
 **/
@Data
public class CommentInfoVO {
    /**
     * id
     */
    private Long id;
    /**
     * 发表评论的用户账号的ID
     */
    private Long userAccountId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 订单ID
     */
    private Long orderInfoId;
    /**
     * 订单商品id
     */
    private Long orderItemId;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 商品sku ID
     */
    private Long goodsSkuId;
    /**
     * 商品sku的销售属性
     */
    private String goodsSkuSaleProperties;
    /**
     * 总评分，1~5
     */
    private Long totalScore;
    /**
     * 商品评分，1~5
     */
    private Long goodsScore;
    /**
     * 客服评分，1~5
     */
    private Long customerServiceScore;
    /**
     * 物流评分，1~5
     */
    private Long logisticsScore;
    /**
     * 评论内容
     */
    private String commentContent;
    /**
     * 是否晒图，1：晒图，0：未晒图
     */
    private Integer isShowPictures;
    /**
     * 是否系统自动给的默认评论，1：是默认评论，0：不是默认评论
     */
    private Integer isDefaultComment;
    /**
     * 评论状态，1：待审核，2：已审核，3：审核不通过，4：已删除
     */
    private Integer commentStatus;
    /**
     * 评论类型，1：好评，总分是4分以上；2：中评，3分；3：差评，1~2分
     */
    private Integer commentType;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
