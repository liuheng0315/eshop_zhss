package com.zhss.eshop.auth.service.impl;

import com.zhss.eshop.auth.composite.PriorityNode;
import com.zhss.eshop.auth.dao.AccountPriorityRelationshipDAO;
import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.dao.RolePriorityRelationshipDAO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.service.PriorityService;
import com.zhss.eshop.auth.visitor.PriorityNodeRelateCheckVisitor;
import com.zhss.eshop.auth.visitor.PriorityNodeRemoveVisitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理模块的service组件
 *
 * @author liuheng
 */
@Slf4j
public class PriorityServiceImpl implements PriorityService {
    @Autowired
    private PriorityDAO priorityDAO;
    @Autowired
    private RolePriorityRelationshipDAO rolePriorityRelationshipDAO;
    @Autowired
    private AccountPriorityRelationshipDAO accountPriorityRelationshipDAO;


    /**
     * 查询根权限的列表
     *
     * @return 根权限集合
     */
    @Override
    public List<PriorityDTO> listRootPriorities() {
        List<PriorityDO> priorityDOS = priorityDAO.listRootPriorities();
        final List<PriorityDTO> priorityDTOS = new ArrayList<>();
        priorityDOS.forEach(k -> priorityDTOS.add(k.clone(PriorityDTO.class)));
        return priorityDTOS;
    }

    /**
     * 查询子权限的列表
     *
     * @param parentId 父权限ID
     * @return 子权限集合
     */
    @Override
    public List<PriorityDTO> listChildPriorities(Long parentId) {
        List<PriorityDO> priorityDOS = priorityDAO.listRootPriorities();
        List<PriorityDTO> priorityDTOS = new ArrayList<>();
        priorityDOS.forEach(k -> priorityDTOS.add(k.clone(PriorityDTO.class)));
        return priorityDTOS;
    }

    /**
     * 新增权限
     *
     * @param priorityDTO 权限DO
     */
    @Override
    public Boolean savePriority(PriorityDTO priorityDTO) {
        return priorityDAO.savePriority(priorityDTO.clone(PriorityDO.class));
    }

    /**
     * 通过id获取权限
     *
     * @param id ID
     * @return 权限
     */
    @Override
    public PriorityDTO getPriorityById(Long id) {
        PriorityDO priorityDO = priorityDAO.getPriorityById(id);
        if (priorityDO == null) {
            return null;
        }
        PriorityDTO priorityDTO = priorityDO.clone(PriorityDTO.class);
        return priorityDTO;
    }

    /**
     * 更新权限
     *
     * @param priorityDTO 权限DO
     */
    @Override
    public Boolean updatePriority(PriorityDTO priorityDTO) {
        return priorityDAO.updatePriority(priorityDTO.clone(PriorityDO.class));
    }

    /**
     * 删除全选
     *
     * @param id 权限id
     * @return 处理结果
     */
    @Override
    public Boolean removePriority(Long id) {

        try {
            // 根据id查询权限
            PriorityDO priorityDO = priorityDAO.getPriorityById(id);
            PriorityNode priorityNode = priorityDO.clone(PriorityNode.class);
            PriorityNodeRelateCheckVisitor checkVisitor = new PriorityNodeRelateCheckVisitor(priorityDAO,
                    rolePriorityRelationshipDAO, accountPriorityRelationshipDAO);
            // 检查权限节点是否被关联
            checkVisitor.visit(priorityNode);
            Boolean relateCheckResult = checkVisitor.getRelateCheckResult();
            if (relateCheckResult) {
                return false;
            }
            // 递归删除当前权限以旗下所有权限
            PriorityNodeRemoveVisitor priorityNodeRemoveVisitor = new PriorityNodeRemoveVisitor(priorityDAO);
            priorityNodeRemoveVisitor.visit(priorityNode);
        } catch (Exception e) {
            log.error("移除权限节点失败:{}", e);
            return false;
        }
        return true;
    }
}
