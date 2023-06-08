package com.zhss.eshop.auth.service.impl;

import com.zhss.eshop.auth.dao.PriorityDao;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.service.PriorityService;
import com.zhss.eshop.common.bean.SpringApplicationContext;
import com.zhss.eshop.common.constant.CollectionSize;
import com.zhss.eshop.common.util.DateProvider;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : liu heng
 * @description :
 * @date : 2023-04-13 00:19
 **/
@Service
@Slf4j
public class PriorityServiceImpl implements PriorityService {
    @Resource
    private PriorityDao priorityDao;
    /**
     * 日期辅助组件
     */
    @Resource
    private DateProvider dateProvider;
    /**
     * spring容器组件
     */
    @Resource
    private SpringApplicationContext context;
    /**
     * 权限缓存管理组件
     */
    @Resource
    private PriorityCacheManager priorityCacheManager;

    /**
     * 查询根权限
     *
     * @return 权限集合
     */
    @Override
    public List<PriorityDTO> listRootPriorities() {
        List<PriorityDO> priorityDOList = priorityDao.listRootPriorities();

        if (priorityDOList == null) {
            return Lists.newArrayList();
        }

        List<PriorityDTO> priorityDTOS = new ArrayList<>(priorityDOList.size());
        priorityDOList.forEach(k -> {
            try {
                priorityDTOS.add(k.clone(PriorityDTO.class));
            } catch (Exception e) {
                log.error("listRootPriorities发生异常", e);
            }
        });

        return priorityDTOS;
    }

    /**
     * 根据父权限id查询子权限
     *
     * @param parentId 父权限id
     * @return 子权限
     * @throws Exception
     */
    @Override
    public List<PriorityDTO> listChildPriorities(Long parentId) throws Exception {
        List<PriorityDO> priorityDOS = priorityDao.listChildPriorities(parentId);
        if (priorityDOS == null) {
            return null;
        }

        List<PriorityDTO> priorityDTOS = Lists.newArrayList();
        for (PriorityDO priorityDO : priorityDOS) {
            PriorityDTO priorityDTO = priorityDO.clone(PriorityDTO.class);
            priorityDTOS.add(priorityDTO);
        }
        return priorityDTOS;
    }

    /**
     * 根据id查询权限
     *
     * @param id 权限id
     * @return 权限
     * @throws Exception
     */
    @Override
    public PriorityDTO getPriorityById(Long id) throws Exception {
        PriorityDO priorityDO = priorityDao.getPriorityById(id);
        if(priorityDO == null) {
            return null;
        }

        return priorityDO.clone(PriorityDTO.class);
    }

    /**
     * 查询账号被授权的权限树
     *
     * @param accountId 账号id
     * @return 权限树
     * @throws Exception
     */
    @Override
    public List<PriorityDTO> listAuthorizedByAccountId(Long accountId) throws Exception {
        List<PriorityDTO> authorizedTree = priorityCacheManager
                .getAuthorizedPriorityTree(accountId);
        if(authorizedTree != null) {
            return authorizedTree;
        }

        QueryAuthorizedPriorityOperation operation = context.getBean(
                QueryAuthorizedPriorityOperation.class);
        operation.setAccountId(accountId);

        authorizedTree = new ArrayList<PriorityDTO>();

        Map<String, Object> parameters = new HashMap<String, Object>(CollectionSize.DEFAULT);
        parameters.put("accountId", accountId);
        parameters.put("parentId", null);

        List<PriorityDO> authorizedRoots = priorityDao.listAuthorizedByAccountId(parameters);

        for(PriorityDO root : authorizedRoots) {
            PriorityDTO targetRoot = root.clone(PriorityDTO.class);
            targetRoot.execute(operation);
            authorizedTree.add(targetRoot);
        }

        priorityCacheManager.cacheAuthorizedPriorityTree(accountId, authorizedTree);

        return authorizedTree;
    }

    /**
     * 判断账号是否存在对指定编号的权限的授权记录
     *
     * @param accountId 账号id
     * @param code      权限编号
     * @return 是否存在授权记录
     * @throws Exception
     */
    @Override
    public Boolean existAuthorizedByCode(Long accountId, String code) throws Exception {
        Boolean authorized = priorityCacheManager.getAuthorizedByCode(accountId, code);
        if(authorized != null) {
            return authorized;
        }

        Long count = priorityDao.countAuthorizedByCode(accountId, code);
        authorized = count > 0 ? true : false;
        priorityCacheManager.cacheAuthorizedByCode(accountId, code, authorized);

        return authorized;
    }

    /**
     * 判断账号是否存在对指定url的权限的授权记录
     *
     * @param accountId 账号id
     * @param url       权限url
     * @return 是否存在授权记录
     * @throws Exception
     */
    @Override
    public Boolean existAuthorizedByUrl(Long accountId, String url) throws Exception {
        Boolean authorized = priorityCacheManager.getAuthorizedByUrl(accountId, url);
        if(authorized != null) {
            return authorized;
        }

        Long count = priorityDao.countAuthorizedByUrl(accountId, url);
        authorized = count > 0 ? true : false;
        priorityCacheManager.cacheAuthorizedByUrl(accountId, url, authorized);

        return authorized;
    }

    /**
     * 新增权限
     *
     * @param priorityDTO 权限
     * @throws Exception
     */
    @Override
    public void savePriority(PriorityDTO priorityDTO) throws Exception {
        priorityDTO.setGmtCreate(dateProvider.getCurrentTime());
        priorityDTO.setGmtModified(dateProvider.getCurrentTime());
        priorityDao.savePriority(priorityDTO.clone(PriorityDO.class));
    }

    /**
     * 更新权限
     *
     * @param priorityDTO 权限
     * @throws Exception
     */
    @Override
    public void updatePriority(PriorityDTO priorityDTO) throws Exception {
        priorityDTO.setGmtModified(dateProvider.getCurrentTime());
        priorityDao.updatePriority(priorityDTO.clone(PriorityDO.class));

        List<Long> accountIds = priorityDao.listAccountIdsByPriorityId(priorityDTO.getId());
        for(Long accountId : accountIds) {
            priorityCacheManager.remove(accountId);
        }
    }

    /**
     * 删除权限
     *
     * @param id 权限id
     * @return 处理结果
     * @throws Exception
     */
    @Override
    public Boolean removePriority(Long id) throws Exception {
        // 根据id查询权限
        PriorityDTO priority = priorityDao.getPriorityById(id)
                .clone(PriorityDTO.class);

        // 检查这个权限以及其下任何一个子权限，是否被角色或者账号给关联着
        RelatedCheckPriorityOperation relatedCheckOperation = context.getBean(
                RelatedCheckPriorityOperation.class);
        Boolean relateCheckResult = priority.execute(relatedCheckOperation);

        if(relateCheckResult) {
            return false;
        }

        // 递归删除当前权限以及其下所有的子权限
        RemovePriorityOperation removeOperation = context.getBean(
                RemovePriorityOperation.class);
        priority.execute(removeOperation);

        return true;
    }
}
