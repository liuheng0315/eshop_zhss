package com.zhss.eshop.finance.service;

import com.zhss.eshop.wms.dto.PurchaseInputOrderDTO;
import com.zhss.eshop.wms.dto.ReturnGoodsInputOrderDTO;
import com.zhss.eshop.wms.dto.SaleDeliveryOrderDTO;

/**
 * @author : liu heng
 * @description : 财务中心对外提供的接口
 * @date : 2023-03-28 22:23
 **/
public interface FinanceFacadeService {
    /**
     * 创建采购结算单
     * @param purchaseInputOrderDTO 采购入库单DTO
     * @return 处理结果
     */
    Boolean createPurchaseSettlementOrder(PurchaseInputOrderDTO purchaseInputOrderDTO);

    /**
     * 给物流公司打款
     * @param saleDeliveryOrderDTO 销售出库单
     * @return 处理结果
     */
    Boolean payForLogisticsCompany(SaleDeliveryOrderDTO saleDeliveryOrderDTO);

    /**
     * 执行退货退款操作
     * @param returnGoodsInputOrderDTO 退货入库单DTO
     * @return 处理结果
     */
    Boolean executeReturnGoodsRefund(ReturnGoodsInputOrderDTO returnGoodsInputOrderDTO);
}
