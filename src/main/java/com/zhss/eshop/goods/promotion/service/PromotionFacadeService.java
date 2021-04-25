package com.zhss.eshop.goods.promotion.service;

import com.zhss.eshop.goods.promotion.service.dto.PromotionActivityDTO;

import java.util.List;

/**
 * 促销中心对外提供的接口
 * @author liuheng
 */
public interface PromotionFacadeService {
    /**
     * 根据商品id查询促销活动
     * @param goodsId 商品ID
     * @return 查询促销活动
     */
    List<PromotionActivityDTO> listPromotionActivitiesByGoodsId(Long goodsId);
}
