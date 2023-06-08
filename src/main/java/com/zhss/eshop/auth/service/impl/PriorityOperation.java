package com.zhss.eshop.auth.service.impl;

import com.zhss.eshop.auth.domain.PriorityDTO;

/**
 * @author : liu heng
 * @description :权限操作接口
 * @date : 2023-06-09 00:48
 **/
public interface PriorityOperation<T> {
    /**
     * 执行这个操作
     * @param priorityDTO 权限
     * @return 处理结果
     * @throws Exception
     */
    T doExecute(PriorityDTO priorityDTO) throws Exception;
}
