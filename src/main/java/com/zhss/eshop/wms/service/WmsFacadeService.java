package com.zhss.eshop.wms.service;

import com.zhss.eshop.order.domain.OrderInfoDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputDTO;
import com.zhss.eshop.wms.domain.SaleDeliveryOrderDTO;

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
     * @param orderInfoDTO
     * @return
     */
    Boolean informSubmitOrderEvent(OrderInfoDTO orderInfoDTO);

    /**
     * 通知wms支付订单事件
     * @param orderInfoDTO
     * @return
     */
    Boolean informPayOrderEvent(OrderInfoDTO orderInfoDTO);

    /**
     * 通知wms取消订单事件
     * @param orderInfoDTO
     * @return
     */
    Boolean informCancelOrderEvent(OrderInfoDTO orderInfoDTO);
}
