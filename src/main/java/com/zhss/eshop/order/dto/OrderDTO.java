package com.zhss.eshop.order.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description :订单DTO
 * @date : 2023-03-20 22:49
 **/
@Data
public class OrderDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 用户账号id
     */
    private String userAccountId;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 收货人
     */
    private String consignee;
    /**
     * 收货人地址
     */
    private String deliveryAddress;
    /**
     * 收货人手机号码
     */
    private String consigneeCellPhoneNumber;
    /**
     * 运费
     */
    private Double freight;
    /**
     * 支付方式
     */
    private Integer payType;
    /**
     * 订单总金额
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
     * 纳税人识别编号
     */
    private String taxpayerId;
    /**
     * 订单备注
     */
    private String orderComment;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
}
