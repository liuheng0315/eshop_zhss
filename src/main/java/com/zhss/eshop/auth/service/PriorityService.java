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

    /**
     * 根据父权限id查询子权限
     * @param parentId 父权限id
     * @return 子权限
     * @throws Exception
     */
    List<PriorityDTO> listChildPriorities(Long parentId) throws Exception;

    /**
     * 根据id查询权限
     * @param id 权限id
     * @return 权限
     * @throws Exception
     */
    PriorityDTO getPriorityById(Long id) throws Exception;

    /**
     * 查询账号被授权的权限树
     * @param accountId 账号id
     * @return 权限树
     * @throws Exception
     */
    List<PriorityDTO> listAuthorizedByAccountId(
            Long accountId) throws Exception;

    /**
     * 判断账号是否存在对指定编号的权限的授权记录
     * @param accountId 账号id
     * @param code 权限编号
     * @return 是否存在授权记录
     * @throws Exception
     */
    Boolean existAuthorizedByCode(Long accountId, String code) throws Exception;

    /**
     * 判断账号是否存在对指定url的权限的授权记录
     * @param accountId 账号id
     * @param url 权限url
     * @return 是否存在授权记录
     * @throws Exception
     */
    Boolean existAuthorizedByUrl(Long accountId, String url) throws Exception;

    /**
     * 新增权限
     * @param priorityDTO 权限
     * @throws Exception
     */
    void savePriority(PriorityDTO priorityDTO) throws Exception;

    /**
     * 更新权限
     * @param priorityDTO 权限
     * @throws Exception
     */
    void updatePriority(PriorityDTO priorityDTO) throws Exception;

    /**
     * 删除权限
     * @param id 权限id
     * @return 处理结果
     * @throws Exception
     */
    Boolean removePriority(Long id) throws Exception;
}
