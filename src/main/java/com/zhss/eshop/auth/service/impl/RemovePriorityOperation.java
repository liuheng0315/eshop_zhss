package com.zhss.eshop.auth.service.impl;

import com.zhss.eshop.auth.dao.PriorityDao;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author : liu heng
 * @description :删除权限操作
 * @date : 2023-06-09 01:29
 **/
@Component
@Scope("prototype")
public class RemovePriorityOperation implements PriorityOperation<Boolean> {
    /**
     * 权限管理模块的DAO组件
     */
    @Autowired
    private PriorityDao priorityDao;

    /**
     * 访问权限树节点
     * @param node 权限树节点
     */
    @Override
    public Boolean doExecute(PriorityDTO node) throws Exception {
        List<PriorityDO> priorityDOList = priorityDao.listChildPriorities(node.getId());

        if(!CollectionUtils.isEmpty(priorityDOList)) {
            for(PriorityDO priorityDO : priorityDOList) {
                PriorityDTO priorityNode = priorityDO.clone(PriorityDTO.class);
                priorityNode.execute(this);
            }
        }

        removePriority(node);

        return true;
    }

    /**
     * 删除权限
     * @param node 权限树节点
     */
    private void removePriority(PriorityDTO node) throws Exception {
        priorityDao.removePriority(node.getId());
    }
}
