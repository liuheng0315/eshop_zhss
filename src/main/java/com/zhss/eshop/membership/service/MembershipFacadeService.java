package com.zhss.eshop.membership.service;

/**
 * @author liuheng
 */
public interface MembershipFacadeService {
    /**
     * 通知会员中心用户今日第一次登陆事件
     * @param userAccountId
     * @return
     */
    Boolean informFirstLoginDaily(Long userAccountId);

    /**
     * 通知会员中心支付订单事件发生了
     * @param userAccountId
     * @param totalOrderAmount
     * @return
     */
    Boolean informPayOrderEvent(Long userAccountId, Long totalOrderAmount);

    /**
     * 通知会员中心，完成退货事件发生了
     * @param userAccountId 用户账号ID
     * @param totalOrderAmount 订单总金额
     * @return 处理结果
     */
    Boolean informFinishReturnGoodsEvent(Long userAccountId, Long totalOrderAmount);

    /**
     * 通知会员中心发表评论事件发生了
     * @param userAccountId 用户账号ID
     * @param showPictures 是否晒图
     * @return 处理结果
     */
    Boolean informPublishCommentEvent(Long userAccountId, Boolean showPictures);

    /**
     * 通过会员中心删除评论事件发生了
     * @param userAccountId 用户ID
     * @param showPictures 是否晒图
     * @return 处理结果
     */
    Boolean informRemoveCommentEvent(Long userAccountId, Boolean showPictures);
}
