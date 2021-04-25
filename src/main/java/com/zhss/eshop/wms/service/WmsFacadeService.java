package com.zhss.eshop.wms.service;

import com.zhss.eshop.order.dto.OrderDTO;
import com.zhss.eshop.wms.dto.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.dto.ReturnGoodsInputDTO;
import com.zhss.eshop.wms.dto.SaleDeliveryOrderDTO;

/**
 * WMS中心对外提供接口
 * @author liuheng
 */
public interface WmsFacadeService {
    /**
     * 创建采购入库单
     * @param purchaseInputOrderDTO 采购入库单
     * @return 入库结果
     */
    Boolean createPurchaseInputOrder(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 创建销售出库单
     * @param saleDeliveryOrderDTO 销售出库单DTO
     * @return 处理结果
     */
    Boolean createSaleDeliveryOrder(SaleDeliveryOrderDTO saleDeliveryOrderDTO);

    /**
     * 创建退货入库单
     * @param returnGoodsInputDTO 退货入库单dto
     * @return 处理结果
     */
    Boolean createReturnGoodsInputOrder(ReturnGoodsInputDTO returnGoodsInputDTO);

    /**
     * 通知wms提交订单事件发生了
     * @param orderDTO
     * @return
     */
    Boolean informSubmitOrderEvent(OrderDTO orderDTO);

    /**
     * 通知wms支付订单事件
     * @param orderDTO
     * @return
     */
    Boolean informPayOrderEvent(OrderDTO orderDTO);

    /**
     * 通知wms取消订单事件
     * @param orderDTO
     * @return
     */
    Boolean informCancelOrderEvent(OrderDTO orderDTO);
}
