package com.zhss.eshop.auth.dao.impl;

import com.zhss.eshop.auth.dao.PriorityDao;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.mapper.PriorityMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author : liu heng
 * @description :权限管理模块的DAO组件
 * @date : 2023-04-13 00:17
 **/
@Repository
public class PriorityDaoImpl implements PriorityDao {
    @Resource
    private PriorityMapper priorityMapper;

    /**
     * 查询根权限
     *
     * @return 权限集合
     */
    @Override
    public List<PriorityDO> listRootPriorities() {
        return priorityMapper.listRootPriorities();
    }

    /**
     * 根据父权限id查询子权限
     *
     * @param parentId 父权限id
     * @return 子权限
     * @throws Exception 异常
     */
    @Override
    public List<PriorityDO> listChildPriorities(Long parentId) throws Exception {
        return priorityMapper.listChildPriorities(parentId);
    }

    /**
     * 根据id查询权限
     *
     * @param id 权限id
     * @return 权限
     * @throws Exception
     */
    @Override
    public PriorityDO getPriorityById(Long id) throws Exception {
        return priorityMapper.getPriorityById(id);
    }

    /**
     * 查询账号被授权的菜单
     *
     * @param parameters 查询参数
     * @return 菜单
     * @throws Exception 异常
     */
    @Override
    public List<PriorityDO> listAuthorizedByAccountId(Map<String, Object> parameters) throws Exception {
        return priorityMapper.listAuthorizedByAccountId(parameters);
    }

    /**
     * 根据权限id查询账号id
     *
     * @param priorityId 权限id
     * @return 账号id
     * @throws Exception
     */
    @Override
    public List<Long> listAccountIdsByPriorityId(Long priorityId) throws Exception {
        return priorityMapper.listAccountIdsByPriorityId(priorityId);
    }

    /**
     * 统计账号对指定编号的权限是否有授权记录
     *
     * @param accountId 账号id
     * @param code      权限编号
     * @return 是否有授权记录
     * @throws Exception
     */
    @Override
    public Long countAuthorizedByCode(Long accountId, String code) throws Exception {
        return priorityMapper.countAuthorizedByCode(accountId, code);
    }

    /**
     * 统计账号对指定URL的权限是否有授权记录
     *
     * @param accountId 账号id
     * @param url       权限url
     * @return 是否有授权记录
     * @throws Exception
     */
    @Override
    public Long countAuthorizedByUrl(Long accountId, String url) throws Exception {
        return priorityMapper.countAuthorizedByUrl(accountId, url);
    }

    /**
     * 新增权限
     *
     * @param priorityDO 权限DO对象
     * @return 权限id
     * @throws Exception
     */
    @Override
    public Long savePriority(PriorityDO priorityDO) throws Exception {
        priorityMapper.savePriority(priorityDO);
        return priorityDO.getId();
    }

    /**
     * 更新权限
     *
     * @param priorityDO 权限DO对象
     * @throws Exception
     */
    @Override
    public void updatePriority(PriorityDO priorityDO) throws Exception {

    }

    /**
     * 删除权限
     *
     * @param id 权限id
     * @throws Exception
     */
    @Override
    public void removePriority(Long id) throws Exception {

    }
}
