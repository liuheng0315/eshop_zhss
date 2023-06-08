package com.zhss.eshop.auth.service;

import com.zhss.eshop.auth.domain.PriorityDTO;

import java.util.List;

/**
 * @author : liu heng
 * @description :权限管理模块的service组件接口
 * @date : 2023-04-13 00:18
 **/
public interface PriorityService {
    /**
     * 查询根权限
     * @return 权限集合
     */
    List<PriorityDTO> listRootPriorities();
}
