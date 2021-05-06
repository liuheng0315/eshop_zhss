package com.zhss.eshop.order.service;

import com.zhss.eshop.order.domain.OrderInfoDTO;

import java.util.List;

/**
 * 订单中心对外提供的接口
 *
 * @author liuheng
 */
public interface OrderFacadeService {
    /**
     * 通知订单中心-商品完成发货
     *
     * @param orderId
     * @return
     */
    Boolean informGoodsDeliveryFinishedEvent(Long orderId);

    /**
     * 通知订单中心-退货拒绝事件发生了
     *
     * @param orderId
     * @return
     */
    Boolean informReturnGoodsWorksheetRejectedEvent(Long orderId);

    /**
     * 通知订单中心-退货工单审核通过
     *
     * @param orderId
     * @return
     */
    Boolean informReturnGoodsWorksheetApprovedEvent(Long orderId);

    /**
     * 通知订单中心-收到退货商品
     *
     * @param orderId
     * @return
     */
    Boolean informGoodsReceived(Long orderId);

    /**
     * 通知订单中心-退货入库单审核通过
     *
     * @param orderId
     * @return
     */
    Boolean informReturnGoodsInputOrderApprovedEvent(Long orderId);

    /**
     * 通知订单中心-完成退款事件发生了
     *
     * @param orderId
     * @return
     */
    Boolean informRefundFinishedEvent(Long orderId);

    /**
     * 订单中心-订单发表评论的事件发生了
     *
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informPublishCommentEvent(Long orderId);

    /**
     * 从订单中心获取，确认收货时间超过了7天，而且还没有发表评论的订单
     *
     * @param orderIds 订单id集合
     * @return 订单信息DTO集合
     */
    List<OrderInfoDTO> listNotPublishedCommentEvent(List<Long> orderIds);

    /**
     * 通知订单中心，"订单批量发表评论"的事件发生了
     *
     * @param orderIds 订单id集合
     * @return 处理结果
     */
    Boolean informBatchPublishCommentEvent(List<Long> orderIds);
}
