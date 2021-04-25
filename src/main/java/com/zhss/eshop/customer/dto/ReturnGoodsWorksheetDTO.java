package com.zhss.eshop.customer.dto;

import lombok.Data;

import java.util.Date;

/**
 * 退货工单
 * @author liuheng
 */
@Data
public class ReturnGoodsWorksheetDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 订单编号
     */
    private Long orderNo;
    /**
     * 退货工单的状态
     */
    private Integer returnGoodsWorksheetStatus;
    /**
     * 退货工单的原因
     */
    private String returnGoodsReason;
    /**
     * 退货的备注
     */
    private String returnGoodsComment;
    /**
     * 退货的物流单号
     */
    private Long returnGoodsCourierNumber;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
