package com.zhss.eshop.wms.domain;

import lombok.Data;

import java.util.Date;

/**
 * 销售出库DTO
 * @author liuheng
 */
@Data
public class SaleDeliveryOrderDTO {
    /**
     * 自增id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单编号
     */
    private Long orderNo;
    /**
     * 用户账号id
     */
    private Long userAccountId;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 收货地址
     */
    private String deliveryAddress;
    /**
     * 收货人电话号码
     */
    private String consigneeCellPhoneNumber;
    /**
     * 运费
     */
    private Double freight;
    /**
     * 支付方式
     */
    private Integer parType;
    /**
     * 总金额
     */
    private Double totalAmount;
    /**
     * 折扣金额
     */
    private Double discountAmount;
    /**
     * 优惠券抵扣金额
     */
    private Double couponAmount;
    /**
     * 应付金额
     */
    private Double payableAmount;
    /**
     * 发票抬头
     */
    private String invoiceTitle;
    /**
     * 纳税人识别号
     */
    private String taxpayerId;
    /**
     * 销售出库单状态
     */
    private Integer saleDeliverOrderStatus;
    /**
     * 实际发货时间
     */
    private Date deliveryTime;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
