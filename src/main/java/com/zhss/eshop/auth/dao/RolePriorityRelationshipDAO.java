package com.zhss.eshop.auth.dao;

/**
 * @author : liu heng
 * @description : 角色权限管理模块的DAO组件
 * @date : 2021-04-28 22:41
 **/
public interface RolePriorityRelationshipDAO {
    /**
     * 根据权限ID查询记录数
     * @param priorityId 权限ID
     * @return 记录数
     */
    Long getCountByPriorityId(Long priorityId);
}
