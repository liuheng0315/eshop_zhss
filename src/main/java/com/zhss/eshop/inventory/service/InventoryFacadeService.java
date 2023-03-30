package com.zhss.eshop.inventory.service;

import com.zhss.eshop.order.dto.OrderDTO;
import com.zhss.eshop.wms.dto.PurchaseInputOrderDTO;

/**
 * @author : liu heng
 * @description :库存中心对外提供的接口
 * @date : 2023-03-28 22:32
 **/
public interface InventoryFacadeService {
    /**
     * 通知库存中心,"采购入库完成"的事件发生了
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    Boolean informPurchaseInputOrderFinished(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 通知库存中心,"提交订单"事件发生了
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
     * 通知库存中心，"取消订单"事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informCancelOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心，"完成退货入库"的事件发生了
     * @param orderDTO 订单DTO
     * @return 处理结果
     */
    Boolean informReturnGoodsInputFinished(OrderDTO orderDTO);

    /**
     * 查询sku的库存
     * @param goodsSkuId 商品sku id
     * @return 商品sku id的库存
     */
    Long getSaleStockQuantity(Long goodsSkuId);
}
