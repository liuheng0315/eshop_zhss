package com.zhss.eshop.auth.service.impl;

import com.zhss.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.zhss.eshop.auth.dao.PriorityDao;
import com.zhss.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : liu heng
 * @description :检查权限是否被关联的操作
 * @date : 2023-06-09 01:17
 **/
@Component
@Scope("prototype")
public class RelatedCheckPriorityOperation implements PriorityOperation<Boolean>{
    /**
     * 关联检查结果
     */
    private Boolean relateCheckResult = false;

    /**
     * 权限管理模块的DAO组件
     */
    @Resource
    private PriorityDao priorityDao;

    /**
     * 角色和权限关系管理模块的DAO组件
     */
    @Resource
    private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;

    /**
     * 账号和权限关系管理模块的DAO组件
     */
    @Resource
    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;

    /**
     * 访问权限树节点
     */
    @Override
    public Boolean doExecute(PriorityDTO node) throws Exception {
        List<PriorityDO> priorityDOs = priorityDao
                .listChildPriorities(node.getId());

        if(priorityDOs != null && priorityDOs.size() > 0) {
            for(PriorityDO priorityDO : priorityDOs) {
                PriorityDTO priorityNode = priorityDO.clone(PriorityDTO.class);
                priorityNode.execute(this);
            }
        }

        if(relateCheck(node)) {
            this.relateCheckResult = true;
        }

        return this.relateCheckResult;
    }

    /**
     * 检查权限是否被任何一个角色或者是账号关联了
     * @param node 权限树节点
     * @return 是否被任何一个角色或者是账号关联了，如果有关联则为true；如果没有关联则为false
     */
    private Boolean relateCheck(PriorityDTO node) throws Exception {
        Long roleRelatedCount = rolePriorityRelationshipDAO
                .countByPriorityId(node.getId());
        if(roleRelatedCount != null && roleRelatedCount > 0) {
            return true;
        }

        Long accountRelatedCount = accountPriorityRelationshipDAO
                .countByPriorityId(node.getId());
        if(accountRelatedCount != null && accountRelatedCount > 0) {
            return true;
        }

        return false;
    }

    public Boolean getRelateCheckResult() {
        return relateCheckResult;
    }

}
