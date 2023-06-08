package com.zhss.eshop.auth.service.impl;

import com.zhss.eshop.auth.dao.PriorityDao;
import com.zhss.eshop.auth.domain.PriorityDO;
import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.service.PriorityService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
}
