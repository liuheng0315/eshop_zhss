package com.zhss.eshop.common.util;

/**
 * @author : liu heng
 * @description : 克隆方向
 * @date : 2023-04-27 22:00
 **/
public class CloneDirection {
    /**
     * 正向克隆：从VO->DTO，DTO->DO
     */
    public static final Integer FORWARD = 1;
    /**
     * 反向克隆：从DO->DTO，DTO->VO
     */
    public static final Integer OPPOSITE = 2;

    private CloneDirection() {

    }
}
