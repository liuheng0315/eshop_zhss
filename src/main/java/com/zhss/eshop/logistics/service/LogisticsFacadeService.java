package com.zhss.eshop.logistics.service;

import com.zhss.eshop.goods.dto.GoodsSkuDTO;

/**
 * 物流中心对外提供接口
 * @author liuheng
 */
public interface LogisticsFacadeService {
    /**
     * 计算运费
     * @param goodsSkuDTO 商品SKU dto
     * @return 商品sku的运费
     */
    Double calculateFreight(GoodsSkuDTO goodsSkuDTO);
}
