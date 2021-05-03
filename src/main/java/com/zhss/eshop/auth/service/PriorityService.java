package com.zhss.eshop.auth.service;

import com.zhss.eshop.auth.composite.PriorityNode;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限管理模块的service接口
 *
 * @author liuheng
 */
public interface PriorityService {
    /**
     * 查询根权限的列表
     *
     * @return 根权限集合
     */
    List<PriorityDTO> listRootPriorities();

    /**
     * 查询子权限的列表
     *
     * @param parentId 父权限ID
     * @return 子权限集合
     */
    List<PriorityDTO> listChildPriorities(Long parentId);


    /**
     * 新增权限
     *
     * @param priorityDTO 权限DO
     * @return
     */
    Boolean savePriority(PriorityDTO priorityDTO);

    /**
     * 通过id获取权限
     *
     * @param id ID
     * @return 权限
     */
    PriorityDTO getPriorityById(Long id);

    /**
     * 更新权限
     *
     * @param priorityDTO 权限DO
     * @return
     */
    Boolean updatePriority(PriorityDTO priorityDTO);

    /**
     * 删除全选
     * @param id 权限id
     * @return 处理结果
     */
    Boolean removePriority(Long id);
}
