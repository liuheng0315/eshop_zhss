package com.zhss.eshop.auth.service.impl;

import com.zhss.eshop.auth.dao.PriorityDAO;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理模块的service组件
 * @author liuheng
 */
public class PriorityServiceImpl implements PriorityService {
    @Autowired
    private PriorityDAO priorityDAO;

    /**
     * 查询根权限的列表
     *
     * @return 根权限集合
     */
    @Override
    public List<PriorityDTO> listRootPriorities() {
        List<PriorityDO> priorityDOS = priorityDAO.listRootPriorities();
        final List<PriorityDTO> priorityDTOS = new ArrayList<>();
        priorityDOS.forEach(k->priorityDTOS.add(k.clone(PriorityDTO.class)));
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
        priorityDOS.forEach(k->priorityDTOS.add(k.clone(PriorityDTO.class)));
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
}
