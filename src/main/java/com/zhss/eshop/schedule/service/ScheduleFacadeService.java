package com.zhss.eshop.schedule.service;

import com.zhss.eshop.customer.domain.ReturnGoodsWorksheetDTO;
import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.purchase.domain.PurchaseOrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputDTO;

/**
 * 调度中心对外提供的接口
 * @author liuheng
 */
public interface ScheduleFacadeService {
    /**
     * 通过库存中心采购入库事件发生了
     * @param purchaseInputOrderDTO 采购入库单
     * @return 处理结果
     */
    Boolean informPurchaseInputFinished(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 通知库存中心提交订单事件发生了
     * @param orderInfoDTO 订单dto
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderInfoDTO orderInfoDTO);

    /**
     * 通知库存中心-支付订单事件发生了
     * @param orderInfoDTO
     * @return
     */
    Boolean informPayOrderEvent(OrderInfoDTO orderInfoDTO);

    /**
     * 通知库存中心-取消订单事件发生了
     * @param orderInfoDTO
     * @return
     */
    Boolean informCancelOrderEvent(OrderInfoDTO orderInfoDTO);

    /**
     * 通知库存中心-完成退货入库事件发生了
     * @param returnGoodsInputDTO 退货入库单DTO
     * @return 处理结果
     */
    Boolean finishReturnGoodsInputFinishedEvent(ReturnGoodsInputDTO returnGoodsInputDTO);

    /**
     * 调度采购入库
     * @param purchaseOrderDTO 采购单DTO
     * @return 处理结果
     */
    Boolean schedulePurchaseInput(PurchaseOrderDTO purchaseOrderDTO);

    /**
     * 调度销售出库
     * @param orderInfoDTO 订单DTO
     * @return 处理结果
     */
    Boolean scheduleSaleDelivery(OrderInfoDTO orderInfoDTO);

    /**
     * 调度退货商品入库
     * @param orderInfoDTO 订单DTO
     * @param returnGoodsWorksheetDTO 退货工单dto
     * @return 处理结果
     */
    Boolean scheduleReturnGoodsInput(OrderInfoDTO orderInfoDTO, ReturnGoodsWorksheetDTO returnGoodsWorksheetDTO);
}
