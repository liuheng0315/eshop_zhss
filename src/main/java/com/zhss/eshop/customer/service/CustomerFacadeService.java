package com.zhss.eshop.customer.service;

/**
 * @author : liu heng
 * @description :客服中心对外提供的接口
 * @date : 2023-03-16 23:32
 **/
public interface CustomerFacadeService {
    /**
     * 创建退货工单
     * @param orderId 订单id
     * @param orderNo 订单号
     * @param returnGoodsReason 退货原因
     * @param returnGoodsComment 退货备注
     * @return 处理结果
     */
    Boolean createReturnGoodsWorksheet(Long orderId, String orderNo,
                                       String returnGoodsReason, String returnGoodsComment);

    /**
     * 同步物流单号
     * @param orderId 订单id
     * @param returnGoodsCourierNumber 退货物流单号
     * @return 处理结果
     */
    Boolean syncReturnGoodsCourierNumber(Long orderId, String returnGoodsCourierNumber);

    /**
     * 通知客服中心 "完成退货入库"的事件发生了
     * @param returnGoodsWorksheetId 退货工单号
     * @return 处理结果
     */
    Boolean informReturnGoodsInputFinishedEvent(Long returnGoodsWorksheetId);

    /**
     * 通知客服中心 "完成退款"的事件发生了
     * @param returnGoodsWorksheetId 退货工单号
     * @return 处理结果
     */
    Boolean informRefundFinishedEvent(Long returnGoodsWorksheetId);
}
