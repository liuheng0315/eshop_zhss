package com.zhss.eshop.schedule.service;

import com.zhss.eshop.customer.dto.ReturnGoodsWorksheetDTO;
import com.zhss.eshop.order.dto.OrderDTO;
import com.zhss.eshop.purchase.dto.PurchaseOrderDTO;
import com.zhss.eshop.wms.dto.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.dto.ReturnGoodsInputOrderDTO;

/**
 * @author : liu heng
 * @description : 调度中心对外提供的接口
 * @date : 2023-03-28 23:33
 **/
public interface ScheduleFacadeService {
    /**
     * 通知库存中心，"采购入库完成"的事件发生了
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    Boolean informPurchaseInputOrderFinished(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 通知库存中心，"提交订单"的事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心，"支付订单"的事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informPayOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心，"取消订单"的事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informCancelOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心，"完成退货入库"的事件发生了
     * @param returnGoodsInputOrderDTO
     * @return
     */
    Boolean informReturnGoodsInputFinished(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

    /**
     * 调度采购入库
     * @param purchaseOrderDTO 采购单DTO
     * @return 处理结果
     */
    Boolean schedulePurchaseInput(PurchaseOrderDTO purchaseOrderDTO);

    /**
     * 调度销售出库
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean scheduleSaleDelivery(OrderDTO orderDTO);

    /**
     * 调度退货入库
     * @param orderDTO 订单DTO
     * @param returnGoodsWorksheetDTO 退货工单DTO
     * @return 处理结果
     */
    Boolean scheduleReturnGoodsInput(OrderDTO orderDTO, ReturnGoodsWorksheetDTO returnGoodsWorksheetDTO);
}
