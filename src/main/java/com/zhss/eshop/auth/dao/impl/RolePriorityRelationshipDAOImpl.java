package com.zhss.eshop.auth.dao.impl;

import com.zhss.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.zhss.eshop.auth.mapper.RolePriorityRelationshipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-04-28 22:44
 **/
@Repository
public class RolePriorityRelationshipDAOImpl implements RolePriorityRelationshipDAO {
    @Autowired
    private RolePriorityRelationshipMapper rolePriorityRelationshipMapper;

    /**
     * 根据权限ID查询记录数
     *
     * @param priorityId 权限ID
     * @return 记录数
     */
    @Override
    public Long getCountByPriorityId(Long priorityId) {
        return rolePriorityRelationshipMapper.getCountByPriorityId(priorityId);
    }
}
