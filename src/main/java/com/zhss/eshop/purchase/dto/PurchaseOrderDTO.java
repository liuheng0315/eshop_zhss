package com.zhss.eshop.purchase.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description :采购单DTO
 * @date : 2023-03-28 23:16
 **/
@Data
public class PurchaseOrderDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 预期到货时间
     */
    private Date expectArrivalTime;
    /**
     * 采购联系人
     */
    private String purchaseContactor;
    /**
     * 采购联系人电话号码
     */
    private String purchaseContactPhoneNumber;
    /**
     * 采购联系人邮箱地址
     */
    private String purchaseContactEmail;
    /**
     * 采购单备注
     */
    private String purchaseOrderComment;
    /**
     * 采购员
     */
    private String purchase;
    /**
     * 采购单状态
     */
    private Integer purchaseOrderStatus;
    /**
     * 采购单创建时间
     */
    private Date gmtCreate;
    /**
     * 采购单更新时间
     */
    private Date gmtModified;
}
