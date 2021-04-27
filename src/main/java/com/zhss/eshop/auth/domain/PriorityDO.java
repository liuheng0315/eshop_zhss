package com.zhss.eshop.auth.domain;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * 权限的DO类
 * @author liuheng
 */
@Data
public class PriorityDO {
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

    /**
     * 克隆方法
     * @param clazz 目标class对象
     * @param <T> clone后的对象
     * @return
     */
    public <T> T clone(Class<T> clazz){
        return null;
    }
}
