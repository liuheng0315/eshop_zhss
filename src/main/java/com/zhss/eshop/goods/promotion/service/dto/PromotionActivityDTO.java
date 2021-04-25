package com.zhss.eshop.goods.promotion.service.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author liuheng
 */
@Data
public class PromotionActivityDTO {
    /**
     * id
     */
    private Integer id;
    /**
     * 促销活动名称
     */
    private String promotionActivityName;
    /**
     * 促销活动的开始时间
     */
    private Date promotionActivityStartTime;
    /**
     * 促销活动的结束时间
     */
    private Date promotionActivityEndTime;
    /**
     * 促销活动的备注
     */
    private Date promotionActivityComment;
    /**
     * 促销活动的状态
     */
    private Date promotionActivityStatus;
    /**
     * 促销活动的规则
     */
    private Date promotionActivityRule;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
