package com.zhss.eshop.auth.service.impl;

import com.zhss.eshop.auth.dao.PriorityDao;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.common.constant.CollectionSize;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : liu heng
 * @description :查询授权权限的操作
 * @date : 2023-06-09 00:54
 **/
@Component
@Scope("prototype")
public class QueryAuthorizedPriorityOperation implements PriorityOperation<Boolean>{
    /**
     * 账号id
     */
    private Long accountId;

    /**
     * 权限管理DAO组件
     */
    @Resource
    private PriorityDao priorityDao;

    /**
     * 执行这个操作
     *
     * @param priorityDTO 权限
     * @return 处理结果
     * @throws Exception
     */
    @Override
    public Boolean doExecute(PriorityDTO priorityDTO) throws Exception {
        List<PriorityDTO> targetChildren = new ArrayList<>();

        Map<String, Object> parameters = new HashMap<>(CollectionSize.DEFAULT);
        parameters.put("accountId", accountId);
        parameters.put("parentId", priorityDTO.getId());

        List<PriorityDO> children = priorityDao.listAuthorizedByAccountId(parameters);
        for(PriorityDO child : children) {
            PriorityDTO targetChild = child.clone(PriorityDTO.class);
            targetChild.execute(this);
            targetChildren.add(targetChild);
        }

        priorityDTO.setChildren(targetChildren);
        return true;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
