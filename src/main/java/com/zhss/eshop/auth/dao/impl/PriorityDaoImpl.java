package com.zhss.eshop.auth.dao.impl;

import com.zhss.eshop.auth.dao.PriorityDao;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.mapper.PriorityMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : liu heng
 * @description :权限管理模块的DAO组件
 * @date : 2023-04-13 00:17
 **/
@Repository
public class PriorityDaoImpl implements PriorityDao {
    @Resource
    private PriorityMapper priorityMapper;

    /**
     * 查询根权限
     *
     * @return 权限集合
     */
    @Override
    public List<PriorityDO> listRootPriorities() {
        return priorityMapper.listRootPriorities();
    }
}
