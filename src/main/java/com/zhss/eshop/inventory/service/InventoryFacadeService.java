package com.zhss.eshop.inventory.service;

import com.zhss.eshop.order.domain.OrderDTO;
import com.zhss.eshop.wms.domain.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.domain.ReturnGoodsInputDTO;

/**
 * 库存中心对外提供的接口
 * @author liuheng
 */
public interface InventoryFacadeService {
    /**
     * 通过库存中心采购入库事件发生了
     * @param purchaseInputOrderDTO 采购入库单
     * @return 处理结果
     */
    Boolean informPurchaseInputFinished(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 通知库存中心提交订单事件发生了
     * @param orderDTO 订单dto
     * @return 处理结果
     */
    Boolean informSubmitOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心-支付订单事件发生了
     * @param orderDTO
     * @return
     */
    Boolean informPayOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心-取消订单事件发生了
     * @param orderDTO
     * @return
     */
    Boolean informCancelOrderEvent(OrderDTO orderDTO);

    /**
     * 通知库存中心-完成退货入库事件发生了
     * @param returnGoodsInputDTO 退货入库单DTO
     * @return 处理结果
     */
    Boolean finishReturnGoodsInputFinishedEvent(ReturnGoodsInputDTO returnGoodsInputDTO);

    /**
     * 查询商品sku库存
     * @param goodsSkuId 商品sku id
     * @return 库存
     */
    Long getSaleStockQuantity(Long goodsSkuId);
}
