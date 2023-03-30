package com.zhss.eshop.wms.service;

import com.zhss.eshop.order.dto.OrderDTO;
import com.zhss.eshop.wms.dto.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.dto.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.dto.SaleDeliveryOrderDTO;

/**
 * @author : liu heng
 * @description : WMS中心对外提供的接口
 * @date : 2023-03-28 22:03
 **/
public interface WmsFacadeService {
    /**
     * 创建采购入库单
     * @param purchaseInputOrderDTO 采购入库DTO
     * @return 处理结果
     */
    Boolean createPurchaseInputOrder(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 创建销售出库单
     * @param saleDeliveryOrderDTO 销售出库DTO
     * @return 处理结果
     */
    Boolean createSaleDeliveryOrder(SaleDeliveryOrderDTO saleDeliveryOrderDTO);

    /**
     * 创建退货入库单
     * @param returnGoodsInputOrderDTO 退货入库DTO
     * @return 处理结果
     */
    Boolean createReturnGoodsInputOrder(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);

    /**
     * 通知WMS中心，"提交订单"的事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderDTO orderDTO);

    /**
     * 通知WMS中心，"取消订单"的事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informCancelOrderEvent(OrderDTO orderDTO);
}
