package com.zhss.eshop.goods.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description :商品sku dto
 * @date : 2023-03-19 23:58
 **/
@Data
public class GoodsSkuDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 商品sku编号
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
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
}
