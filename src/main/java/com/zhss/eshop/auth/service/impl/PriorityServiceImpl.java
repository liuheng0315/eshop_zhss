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
        List<PriorityDTO> priorityDTOS = new ArrayList<>();
        return null;
    }
}
