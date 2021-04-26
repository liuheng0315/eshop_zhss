package com.zhss.eshop.purchase.domain;

import lombok.Data;

import java.util.Date;

/**
 * 采购入库单DTO
 * @author liuheng
 */
@Data
public class PurchaseOrderDTO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 供应商ID
     */
    private Long supplierId;
    /**
     * 期望到达时间
     */
    private Date expectArrivalTime;
    /**
     * 实际到达实际
     */
    private Date arrivalTime;
    /**
     * 采购联系人
     */
    private String purchaseContactor;
    /**
     * 采购联系人电话
     */
    private String purchaseContactorPhoneNumber;
    /**
     * 采购联系人邮箱
     */
    private String purchaseContactorPhoneEmail;
    /**
     * 采购单备注
     */
    private String purchaseOrderComment;
    /**
     * 采购员
     */
    private String purchase;
    /**
     * 采购单的状态
     */
    private Integer purchaseOrderStatus;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
