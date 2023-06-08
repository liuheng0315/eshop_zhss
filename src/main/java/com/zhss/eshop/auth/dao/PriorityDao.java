package com.zhss.eshop.auth.dao;

import com.zhss.eshop.auth.domain.PriorityDO;

import java.util.List;

/**
 * @author : liu heng
 * @description :权限管理DAO模块
 * @date : 2023-04-13 00:15
 **/
public interface PriorityDao {
    /**
     * 查询根权限
     * @return 权限集合
     */
    List<PriorityDO> listRootPriorities();
}
