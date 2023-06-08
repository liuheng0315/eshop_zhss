package com.zhss.eshop.auth.domain;

import com.zhss.eshop.common.util.AbstractObject;
import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description : 权限VO类
 * @date : 2023-04-12 23:47
 **/
@Data
public class PriorityVO extends AbstractObject {
    /**
     * id
     */
    private Long id;
    /**
     * 权限编号
     */
    private String code;
    /**
     * 权限的url
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
     * 父权限
     */
    private Long parentId;
    /**
     * 权限的创建时间
     */
    private String gmtCreate;
    /**
     * 权限的更新时间
     */
    private String gmtModified;
}
