package com.zhss.eshop.auth.dao.impl;

import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.mapper.PriorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限管理模块的DAO组件
 * @author liuheng
 */
@Repository
public class PriorityDAOImpl implements PriorityDAO {
    /**
     * 权限管理模块的mapper组件
     */
    @Autowired
    private PriorityMapper priorityMapper;

    /**
     * 查询根权限的列表
     *
     * @return 根权限集合
     */
    @Override
    public List<PriorityDO> listRootPriorities() {
        return priorityMapper.listRootPriorities();
    }
}
