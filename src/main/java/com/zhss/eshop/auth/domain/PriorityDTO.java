package com.zhss.eshop.auth.domain;

import com.zhss.eshop.auth.service.impl.PriorityOperation;
import com.zhss.eshop.common.util.AbstractObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : liu heng
 * @description : 权限DTO类
 * @date : 2023-04-12 23:47
 **/
@Data
public class PriorityDTO extends AbstractObject {
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
    private Date gmtCreate;
    /**
     * 权限的更新时间
     */
    private Date gmtModified;
    /**
     * 子权限节点
     */
    private List<PriorityDTO> children = new ArrayList<PriorityDTO>();

    /**
     * 接收一个权限树访问者
     * @param operation 权限树访问者
     */
    public <T> T execute(PriorityOperation<T> operation) throws Exception {
        return operation.doExecute(this);
    }
}
