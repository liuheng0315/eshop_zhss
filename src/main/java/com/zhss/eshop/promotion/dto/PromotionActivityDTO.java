package com.zhss.eshop.promotion.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description : 促销活动DTO
 * @date : 2023-03-28 23:05
 **/
@Data
public class PromotionActivityDTO {
    /**
     * id
     */
    private Long id;
    /**
     * 促销活动名称
     */
    private String promotionActivityName;
    /**
     * 促销活动开始时间
     */
    private Date promotionActivityStartTime;
    /**
     * 促销活动结束事件
     */
    private Date promotionActivityEndTime;
    /**
     * 促销活动备注
     */
    private String promotionActivityComment;
    /**
     * 促销活动状态
     */
    private Integer promotionActivityStatus;
    /**
     * 促销活动规则
     */
    private String promotionActivityRule;
    /**
     * 促销活动的创建时间
     */
    private Date gmtCreate;
    /**
     * 促销活动修改时间
     */
    private Date gmtModified;
}
