package com.zhss.eshop.commodity.service;

import com.zhss.eshop.commodity.domain.GoodsSkuDTO;

/**
 * 商品中心统一对外暴露的接口
 * @author liuheng
 */
public interface CommodityFacadeService {
    /**
     * 根据id查询商品sku
     * @param goodsSkuId sku id
     * @return 商品dto
     */
    GoodsSkuDTO getGoodsSkuById(Long goodsSkuId);
}
