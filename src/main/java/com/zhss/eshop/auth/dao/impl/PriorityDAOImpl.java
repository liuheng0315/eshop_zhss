package com.zhss.eshop.auth.dao.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
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

    /**
     * 查询子权限的列表
     *
     * @param parentId
     * @return 子权限集合
     */
    @Override
    public List<PriorityDO> listChildPriorities(Long parentId) {
        return priorityMapper.listChildPriorities(parentId);
    }

    /**
     * 新增权限
     *
     * @param priorityDO 权限DO
     */
    @Override
    public Boolean savePriority(PriorityDO priorityDO) {
        priorityMapper.savePriority(priorityDO);
        return true;
    }

    /**
     * 通过id获取权限
     *
     * @param id ID
     * @return 权限
     */
    @Override
    public PriorityDO getPriorityById(Long id) {
        return priorityMapper.getPriorityById(id);
    }

    /**
     * 更新权限
     *
     * @param priorityDO 权限DO
     */
    @Override
    public Boolean updatePriority(PriorityDO priorityDO) {
        priorityMapper.updatePriority(priorityDO);
        return true;
    }

    /**
     * 删除权限
     *
     * @param id 权限Id
     * @return 处理结果
     */
    @Override
    public Boolean removePriority(Long id) {
        try {
            priorityMapper.removePriority(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
