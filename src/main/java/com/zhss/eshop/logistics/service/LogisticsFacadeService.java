package com.zhss.eshop.logistics.service;

import com.zhss.eshop.commodity.dto.GoodsSkuDTO;

/**
 * @author : liu heng
 * @description : 物流中心对外提供的接口
 * @date : 2023-03-28 22:49
 **/
public interface LogisticsFacadeService {
    /**
     * 计算商品sku的运费
     * @param goodsSkuDTO 商品sku DTO
     * @return 商品sku的运费
     */
    Double calculateFreight(GoodsSkuDTO goodsSkuDTO);
}
