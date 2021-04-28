package com.zhss.eshop.auth.dao;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-04-28 22:50
 **/
public interface AccountPriorityRelationshipDAO {
    /**
     * 根据权限ID查询记录数
     * @param priorityId 权限ID
     * @return 记录数
     */
    Long getCountByPriorityId(Long priorityId);
}
