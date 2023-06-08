package com.zhss.eshop.commodity.service;

import com.zhss.eshop.commodity.dto.GoodsSkuDTO;

/**
 * @author : liu heng
 * @description : 商品中心对外提供的接口
 * @date : 2023-03-20 00:03
 **/
public interface GoodsFacadeService {
    /**
     * 根据id查询商品sku
     * @param goodsSkuId 商品sku id
     * @return 商品sku DTO
     */
    GoodsSkuDTO getGoodsSkuById(Long goodsSkuId);
}
