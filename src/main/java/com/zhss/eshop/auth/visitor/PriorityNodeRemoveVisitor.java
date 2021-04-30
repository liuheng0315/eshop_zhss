package com.zhss.eshop.auth.visitor;

import com.zhss.eshop.auth.composite.PriorityNode;
import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;

import java.util.List;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-04-30 13:21
 **/
public class PriorityNodeRemoveVisitor implements PriorityNodeVisitor {
    /**
     * 权限管理模块的dao组件
     */
    private PriorityDAO priorityDAO;

    /**
     * 构造函数
     * @param priorityDAO 权限管理的DAO组件
     */
    public PriorityNodeRemoveVisitor(PriorityDAO priorityDAO) {
        this.priorityDAO = priorityDAO;
    }

    /**
     * 访问权限树节点
     *
     * @param priorityNode
     */
    @Override
    public void visit(PriorityNode priorityNode) {
        List<PriorityDO> priorityDOS = priorityDAO.listChildPriorities(priorityNode.getId());
        if (priorityDOS != null && priorityDOS.size() > 0) {
            for (PriorityDO node : priorityDOS) {
                PriorityNode pNode = node.clone(PriorityNode.class);
                pNode.accept(this);
            }
        }
    }
}
