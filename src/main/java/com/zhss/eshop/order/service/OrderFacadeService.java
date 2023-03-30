package com.zhss.eshop.order.service;

/**
 * @author : liu heng
 * @description :订单中心对外提供的接口
 * @date : 2023-03-20 23:45
 **/
public interface OrderFacadeService {
    /**
     * 通知订单中心 商品完成发货的通知
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informGoodsDeliveryFinishedEvent(Long orderId);

    /**
     * 通知订单中心 "退货工单审核不通过"的事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informReturnGoodsWorksheetRejectedEvent(Long orderId);

    /**
     * 通知订单中心 "退货工单审核通过"的事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informReturnGoodsWorksheetApprovedEvent(Long orderId);

    /**
     * 通知订单中心 "退货商品到货"的事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informReturnGoodsReceivedEvent(Long orderId);

    /**
     * 通知订单中心 "退货入库单审核通过"的事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informReturnGoodsInputOrderApprovedEvent(Long orderId);

    /**
     * 通知订单中心 "完成退款"事件发生了
     * @param orderId 订单id
     * @return 处理结果
     */
    Boolean informRefundFinishedEvent(Long orderId);
}
