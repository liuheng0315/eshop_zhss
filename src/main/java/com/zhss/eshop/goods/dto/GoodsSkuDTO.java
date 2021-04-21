package com.zhss.eshop.goods.dto;

import lombok.Data;

import java.util.Date;

/**
 * 商品sku
 * @author liuheng
 */
@Data
public class GoodsSkuDTO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 商品ID
     */
    private Long goodsId;
    /**
     * 商品的sku编号
     */
    private String goodsSkuCode;
    /**
     * 采购价格
     */
    private Double purchasePrice;
    /**
     * 销售价格
     */
    private Double salePrice;
    /**
     * 折扣价格
     */
    private Double discountPrice;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
