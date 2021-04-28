package com.zhss.eshop.auth.visitor;

import com.zhss.eshop.auth.composite.PriorityNode;

/**
 * @author : liu heng
 * @description : 权限树访问者模式
 * @date : 2021-04-28 12:57
 **/
public interface PriorityNodeVisitor {
    /**
     * 访问权限树节点
     * @param priorityNode
     */
    void visit(PriorityNode priorityNode);
}
