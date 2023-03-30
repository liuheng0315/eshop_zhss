package com.zhss.eshop.membership.service;

/**
 * @author : liu heng
 * @description :会员中心对外提供的接口
 * @date : 2023-03-28 22:53
 **/
public interface MembershipFacadeService {
    /**
     * 通知会员中心，"用户今天第一次登录"的事件发生了
     * @param userAccountId 用户账号ID
     * @return 处理结果
     */
    Boolean informFirstLoginDailyEvent(Long userAccountId);

    /**
     * 通知会员中心,"支付订单"的事件发生了
     * @param userAccountId 用户账号ID
     * @param totalOrderAmount 订单总金额
     * @return 处理结果
     */
    Boolean informPayOrderEvent(Long userAccountId, Long totalOrderAmount);

    /**
     * 通知会员中心，"完成退货"的事件发生了
     * @param userAccountId 用户账号ID
     * @param totalOrderAmount 总订单金额
     * @return 处理结果
     */
    Boolean informFinishedReturnGoodsEvent(Long userAccountId, Long totalOrderAmount);

    /**
     * 通知会员中心，"发表评论"事件发生了
     * @param userAccountId 用户账户ID
     * @param showPictures 是否晒图
     * @return 处理结果
     */
    Boolean informPublishCommentEvent(Long userAccountId, Boolean showPictures);

    /**
     * 通知会员中心，"删除评论"的事件发生了
     * @param userAccountId 用户账号ID
     * @param showPictures 是否晒图
     * @return 处理结果
     */
    Boolean informRemoveCommentEvent(Long userAccountId, Boolean showPictures);
}
