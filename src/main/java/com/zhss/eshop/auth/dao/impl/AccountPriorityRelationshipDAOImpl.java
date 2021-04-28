package com.zhss.eshop.auth.dao.impl;

import com.zhss.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.zhss.eshop.auth.mapper.AccountPriorityRelationshipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author : liu heng
 * @description : 账号和权限映射关系模块
 * @date : 2021-04-28 22:50
 **/
@Repository
public class AccountPriorityRelationshipDAOImpl implements AccountPriorityRelationshipDAO {
    @Autowired
    private AccountPriorityRelationshipMapper accountPriorityRelationshipMapper;

    /**
     * 根据权限ID查询记录数
     *
     * @param priorityId 权限ID
     * @return 记录数
     */
    @Override
    public Long getCountByPriorityId(Long priorityId) {
        return accountPriorityRelationshipMapper.getCountByPriorityId(priorityId);
    }
}
