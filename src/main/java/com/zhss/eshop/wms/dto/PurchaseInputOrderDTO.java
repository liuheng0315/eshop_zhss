package com.zhss.eshop.wms.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description :采购入库单DTO
 * @date : 2023-03-21 23:57
 **/
@Data
public class PurchaseInputOrderDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 供应商id
     */
    private Long supplierId;
    /**
     * 预期到达时间
     */
    private Date expectArrivalTime;
    /**
     * 实际到达时间
     */
    private Date arrivalTime;
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
     * 采购入库单备注
     */
    private String purchaseInputOrderComment;
    /**
     * 采购员
     */
    private String purchase;
    /**
     * 采购入库单状态
     */
    private Integer purchaseInputOrderStatus;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
}
