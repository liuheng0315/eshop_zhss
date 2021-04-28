package com.zhss.eshop.auth.domain;

import com.zhss.eshop.common.util.BeanCopierUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 权限的DO类
 * @author liuheng
 */
@Data
public class PriorityVO {
    private static final Logger logger = LoggerFactory.getLogger(PriorityDO.class);
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
     *
     * @param clazz 目标class对象
     * @param <T>   clone后的对象
     * @return
     */
    public <T> T clone(Class<T> clazz) {
        T target = null;
        try {
            target = clazz.newInstance();
        } catch (Exception e) {
            logger.error("克隆对象出错", e);
        }
        BeanCopierUtils.copyProperties(this, target);
        return target;
    }
}
