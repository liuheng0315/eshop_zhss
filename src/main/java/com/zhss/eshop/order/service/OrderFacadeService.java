package com.zhss.eshop.order.service;

/**
 * 订单中心对外提供的接口
 * @author liuheng
 */
public interface OrderFacadeService {
    /**
     * 通知订单中心-商品完成发货
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
     * @param orderId
     * @return
     */
    Boolean informReturnGoodsWorksheetApprovedEvent(Long orderId);

    /**
     * 通知订单中心-收到退货商品
     * @param orderId
     * @return
     */
    Boolean informGoodsReceived(Long orderId);

    /**
     * 通知订单中心-退货入库单审核通过
     * @param orderId
     * @return
     */
    Boolean informReturnGoodsInputOrderApprovedEvent(Long orderId);

    /**
     * 通知订单中心-完成退款事件发生了
     * @param orderId
     * @return
     */
    Boolean informRefundFinishedEvent(Long orderId);
}
