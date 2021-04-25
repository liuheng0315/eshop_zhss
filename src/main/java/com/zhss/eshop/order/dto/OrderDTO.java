package com.zhss.eshop.order.dto;

import lombok.Data;

import java.util.Date;

/**
 * 订单dto
 * @author liuheng
 */
@Data
public class OrderDTO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 用户的账号id
     */
    private Long userAccountId;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 退货入库单的状态
     */
    private Integer returnGoodsInputOrderStatus;
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
     * 订单备注
     */
    private String orderComment;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
