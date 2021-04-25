package com.zhss.eshop.customer.service;

/**
 * 客服中心对外提供的接口
 * @author liuheng
 */
public interface CustomerFacadeService {
    /**
     * 创建退货工单
     *
     * @param orderId            订单ID
     * @param orderNo            订单编号
     * @param returnGoodsReason  退货原因
     * @param returnGoodsComment 退货备注
     * @return 处理结果
     */
    Boolean createReturnGoodsWorksheet(Long orderId, String orderNo, String returnGoodsReason, String returnGoodsComment);

    /**
     * 同步物流单号
     * @param orderId 订单ID
     * @param ReturnGoodsCourierNumber 退货物流单号
     * @return 处理结果
     */
    Boolean syncReturnGoodsCourierNumber(Long orderId, String ReturnGoodsCourierNumber);

    /**
     * 通知客服中心完成退货入库事件发生
     * @param returnGoodsWorksheetId 退货工单id
     * @return 处理结果
     */
    Boolean informFinishReturnGoodsInputFinishedEvent(Long returnGoodsWorksheetId);

    /**
     * 通知客服中心完成退货打款的事件
     * @param returnGoodsWorksheetId 退货工单ID
     * @return 处理结果
     */
    Boolean informRefundFinishedEvent(Long returnGoodsWorksheetId);
}
