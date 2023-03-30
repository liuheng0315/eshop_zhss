package com.zhss.eshop.promotion.service;

import com.zhss.eshop.promotion.dto.PromotionActivityDTO;

import java.util.List;

/**
 * @author : liu heng
 * @description :促销中心对外提供的接口
 * @date : 2023-03-28 23:11
 **/
public interface PromotionFacadeService {
    /**
     * 根据商品id查询促销活动
     * @param goodsId 商品id
     * @return 处理结果
     */
    List<PromotionActivityDTO> listPromotionActivitiesByGoodsId(Long goodsId);
}
