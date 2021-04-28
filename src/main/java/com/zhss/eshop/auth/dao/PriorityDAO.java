package com.zhss.eshop.auth.dao;

import com.zhss.eshop.auth.domain.PriorityDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限管理模块的DAO组件接口
 *
 * @author liuheng
 */
public interface PriorityDAO {
    /**
     * 查询根权限的列表
     *
     * @return 根权限集合
     */
    List<PriorityDO> listRootPriorities();

    /**
     * 查询子权限的列表
     * @param parentId 父权限ID
     * @return 子权限集合
     */
    List<PriorityDO> listChildPriorities(Long parentId);

    /**
     * 新增权限
     * @param priorityDO 权限DO
     */
    Boolean savePriority(PriorityDO priorityDO);

    /**
     * 通过id获取权限
     * @param id ID
     * @return 权限
     */
    PriorityDO getPriorityById(Long id);

    /**
     * 更新权限
     * @param priorityDO 权限DO
     */
    Boolean updatePriority(PriorityDO priorityDO);
}
