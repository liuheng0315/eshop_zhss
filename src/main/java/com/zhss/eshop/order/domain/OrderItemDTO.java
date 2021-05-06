package com.zhss.eshop.order.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description : 订单条目DTO
 * @date : 2021-05-06 00:05
 **/
@Data
public class OrderItemDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 商品sku id
     */
    private Long goodsSkuId;
    /**
     * 商品sku编号
     */
    private String goodSkuCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品SKU销售属性
     */
    private String saleProperties;
    /**
     * 商品毛重
     */
    private Double goodsGrossWeight;
    /**
     * 商品sku的购买数量
     */
    private Long purchaseQuantity;
    /**
     * 商品sku的购买价格
     */
    private Double purchasePrice;
    /**
     * 使用活动促销的id
     */
    private Long promotionActivityId;
    /**
     * 商品sku的长度
     */
    private Double goodsLength;
    /**
     * 商品sku的宽度
     */
    private Double goodsWidth;
    /**
     * 商品SKU的高度
     */
    private Double goodsHeight;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
