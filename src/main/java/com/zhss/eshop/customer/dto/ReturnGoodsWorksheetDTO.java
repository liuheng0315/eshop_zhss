package com.zhss.eshop.customer.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description :退货工单DTO
 * @date : 2023-03-16 23:26
 **/
@Data
public class ReturnGoodsWorksheetDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 退货工单的状态
     */
    private Integer returnGoodsWorksheetStatus;
    /**
     * 退货原因
     */
    private String returnGoodsReason;
    /**
     * 退货备注
     */
    private String returnGoodsComment;
    /**
     * 退货工单的创建时间
     */
    private Date gmtCreat;
    /**
     * 退货工单的修改时间
     */
    private Date gmtModified;
}
