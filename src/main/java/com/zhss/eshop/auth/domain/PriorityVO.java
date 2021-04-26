package com.zhss.eshop.auth.domain;

import lombok.Data;

import java.util.Date;

/**
 * 权限的DO类
 * @author liuheng
 */
@Data
public class PriorityVO {
    /**
     * id
     */
    private Long id;
    /**
     * 编号
     */
    private String code;
    /**
     * 权限url
     */
    private String url;
    /**
     * 权限备注
     */
    private String priorityComment;
    /**
     * 权限类型
     */
    private Integer priorityType;
    /**
     * 父权限id
     */
    private Long parentId;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;
}
