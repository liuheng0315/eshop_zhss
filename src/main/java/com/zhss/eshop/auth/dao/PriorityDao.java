package com.zhss.eshop.auth.dao;

import com.zhss.eshop.auth.domain.PriorityDO;

import java.util.List;
import java.util.Map;

/**
 * @author : liu heng
 * @description :权限管理DAO模块
 * @date : 2023-04-13 00:15
 **/
public interface PriorityDao {
    /**
     * 查询根权限
     * @return 权限集合
     */
    List<PriorityDO> listRootPriorities();

    /**
     * 根据父权限id查询子权限
     * @param parentId 父权限id
     * @return 子权限
     * @throws Exception 异常
     */
    List<PriorityDO> listChildPriorities(Long parentId) throws Exception;

    /**
     * 根据id查询权限
     * @param id 权限id
     * @return 权限
     * @throws Exception
     */
    PriorityDO getPriorityById(Long id) throws Exception;

    /**
     * 查询账号被授权的菜单
     * @param parameters 查询参数
     * @return 菜单
     * @throws Exception 异常
     */
    List<PriorityDO> listAuthorizedByAccountId(Map<String, Object> parameters) throws Exception;

    /**
     * 根据权限id查询账号id
     * @param priorityId 权限id
     * @return 账号id
     * @throws Exception
     */
    List<Long> listAccountIdsByPriorityId(Long priorityId) throws Exception;

    /**
     * 统计账号对指定编号的权限是否有授权记录
     * @param accountId 账号id
     * @param code 权限编号
     * @return 是否有授权记录
     * @throws Exception
     */
    Long countAuthorizedByCode(Long accountId, String code) throws Exception;

    /**
     * 统计账号对指定URL的权限是否有授权记录
     * @param accountId 账号id
     * @param url 权限url
     * @return 是否有授权记录
     * @throws Exception
     */
    Long countAuthorizedByUrl(Long accountId, String url) throws Exception;

    /**
     * 新增权限
     * @param priorityDO 权限DO对象
     * @return 权限id
     * @throws Exception
     */
    Long savePriority(PriorityDO priorityDO) throws Exception;

    /**
     * 更新权限
     * @param priorityDO 权限DO对象
     * @throws Exception
     */
    void updatePriority(PriorityDO priorityDO) throws Exception;

    /**
     * 删除权限
     * @param id 权限id
     * @throws Exception
     */
    void removePriority(Long id) throws Exception;
}
