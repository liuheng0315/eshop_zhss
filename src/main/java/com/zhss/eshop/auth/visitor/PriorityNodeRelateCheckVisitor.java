package com.zhss.eshop.auth.visitor;

import com.zhss.eshop.auth.composite.PriorityNode;
import com.zhss.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.zhss.eshop.auth.domain.PriorityDO;

import java.util.List;

/**
 * @author : liu heng
 * @description : 权限树关联检查
 * @date : 2021-04-28 22:17
 **/
public class PriorityNodeRelateCheckVisitor implements PriorityNodeVisitor{
    /**
     * 权限树关联检查结果
     */
    private Boolean relateCheckResult;

    /**
     * 权限管理模块的DAO组件
     */
    private PriorityDAO priorityDAO;

    /**
     * 角色与权限关系的DAO组件
     */
    private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;

    /**
     * 账号与权限关系的DAO组件
     */
    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;

    public PriorityNodeRelateCheckVisitor(PriorityDAO priorityDAO,
                                          RolePriorityRelationshipDAO rolePriorityRelationshipDAO,
                                          AccountPriorityRelationshipDAO accountPriorityRelationshipDAO) {
        this.priorityDAO = priorityDAO;
        this.rolePriorityRelationshipDAO = rolePriorityRelationshipDAO;
        this.accountPriorityRelationshipDAO = accountPriorityRelationshipDAO;
    }

    /**
     * 访问权限树节点
     *
     * @param node
     */
    @Override
    public void visit(PriorityNode node) {
        List<PriorityDO> children = priorityDAO.listChildPriorities(node.getParentId());
        if (children != null && children.size() > 0) {
            for (PriorityDO priorityDO : children) {
                PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
                priorityNode.accept(this);
            }
        }

        if (relateCheck(node)) {
            this.relateCheckResult = true;
        }
    }

    /**
     * 检查权限树是否被关联
     * @param priorityNode 权限节点
     * @return 是否被关联
     */
    private Boolean relateCheck(PriorityNode priorityNode) {
        Long roleRelatedCount = rolePriorityRelationshipDAO.getCountByPriorityId(priorityNode.getId());

        if (roleRelatedCount != null && roleRelatedCount > 0) {
            return true;
        }

        Long accountRelatedCount = accountPriorityRelationshipDAO.getCountByPriorityId(priorityNode.getId());
        if (accountRelatedCount != null && accountRelatedCount > 0) {
            return true;
        }
        return false;
    }
}
