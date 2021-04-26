package com.zhss.eshop.auth.dao;

import com.zhss.eshop.auth.domain.PriorityDO;

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
}
