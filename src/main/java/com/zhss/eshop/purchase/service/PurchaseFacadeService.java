package com.zhss.eshop.purchase.service;

/**
 * 采购中心对外接口
 *
 * @author liuheng
 */
public interface PurchaseFacadeService {
    /**
     * 判断是否有关联商品sku的采购单
     *
     * @param goodsSkuId 商品的sku id
     * @return 是否有采购单关联商品sku
     */
    Boolean existRelatedPurchaseOrder(Long goodsSkuId);

    /**
     * 通知采购中心创建采购入库单事件
     *
     * @param purchaseOrderId 采购入库单
     * @return 处理结果
     */
    Boolean informCreatePurchaseInputOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心完成采购入库单事件
     *
     * @param purchaseOrderId 采购入库单
     * @return 处理结果
     */
    Boolean informFinishedPurchaseInputOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心创建采购结算单事件
     *
     * @param purchaseOrderId 采购单
     * @return 处理结果
     */
    Boolean informCreatePurchaseSettlementOrderEvent(Long purchaseOrderId);

    /**
     * 通知采购中心完成采购结算单事件
     *
     * @param purchaseOrderId 采购单
     * @return 处理结果
     */
    Boolean informFinishedPurchaseSettlementOrderEvent(Long purchaseOrderId);
}
