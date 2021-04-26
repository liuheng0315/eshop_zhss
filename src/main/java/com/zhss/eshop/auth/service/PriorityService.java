package com.zhss.eshop.auth.service;

import com.zhss.eshop.auth.domain.PriorityDTO;

import java.util.List;

/**
 * 权限管理模块的service接口
 * @author liuheng
 */
public interface PriorityService {
    /**
     * 查询根权限的列表
     *
     * @return 根权限集合
     */
    List<PriorityDTO> listRootPriorities();
}
