package com.zhss.eshop.auth.controller;

import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.domain.PriorityVO;
import com.zhss.eshop.auth.service.PriorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : liu heng
 * @description :
 * @date : 2023-04-13 00:22
 **/
@RestController
@RequestMapping("/auth/priority")
@Slf4j
public class PriorityController {
    @Resource
    private PriorityService priorityService;

    /**
     *  查询根权限
     * @return 根权限集合
     */
    @GetMapping("/root")
    public List<PriorityVO> listRootPriorities() {
        try {
            List<PriorityDTO> priorityDTOS = priorityService.listRootPriorities();
            if (priorityDTOS == null) {
                priorityDTOS = new ArrayList<>();
            }
            List<PriorityVO> priorityVOS = new ArrayList<>(priorityDTOS.size());
            priorityDTOS.forEach(k -> {
                try {
                    priorityVOS.add(k.clone(PriorityVO.class));
                } catch (Exception e) {
                    log.error("listRootPriorities clone 异常", e);
                }
            });
            return priorityVOS;
        } catch (Exception e) {
            log.error("error", e);
        }
        return new ArrayList<>();
    }
}
