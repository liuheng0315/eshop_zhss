package com.zhss.eshop.purchase.service;

/**
 * @author : liu heng
 * @description : 采购中心对外提供的接口
 * @date : 2023-03-28 23:24
 **/
public interface PurchaseFacadeService {
    /**
     * 判断是否有关联的商品sku的采购单
     * @param goodsSkuId 商品sku id
     * @return 是否有关联的商品sku的采购单
     */
    Boolean existRelationPurchaseOrder(Long goodsSkuId);

    /**
     * 通知采购中心，"采购入库单"事件发生了
     * @param purchaseOrderId 采购单id
     * @return 处理结果
     */
    Boolean informCreatePurchaseInputOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心，"完成采购入库单"的事件发生了
     * @param purchaseOrderId 采购单id
     * @return 处理结果
     */
    Boolean informFinishedPurchaseInputOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心，"创建采购入库结算单"的事件发生了
     * @param purchaseOrderId 采购单id
     * @return 处理结果
     */
    Boolean informCreatePurchaseSettlementOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心，"完成采购结算单"的事件发生了
     * @param purchaseOrderId 采购单id
     * @return 处理结果
     */
    Boolean informFinishedPurchaseSettlementOrderEvent(Long purchaseOrderId);
}
