package com.zhss.eshop.auth.controller;

import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.domain.PriorityVO;
import com.zhss.eshop.auth.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理模块的controller组件
 * @author liuheng
 */
@RestController
@RequestMapping("/auth/priority")
public class PriorityController {
    @Autowired
    private PriorityService priorityService;

    /**
     * 查询根权限
     * @return 权限列表
     */
    @GetMapping("/root")
    public List<PriorityVO> listRootPriorities(){
        List<PriorityDTO> priorityDTOS = priorityService.listRootPriorities();
        List<PriorityVO> priorityVOS = new ArrayList<>(priorityDTOS.size());
        priorityDTOS.forEach(k->priorityVOS.add(k.clone(PriorityVO.class)));
        return priorityVOS;
    }

    /**
     * 查询根权限
     * @return 权限列表
     */
    @GetMapping("/child")
    public List<PriorityVO> listChildPriorities(@RequestParam Long parentId){
        List<PriorityDTO> priorityDTOS = priorityService.listChildPriorities(parentId);
        List<PriorityVO> priorityVOS = new ArrayList<>(priorityDTOS.size());
        priorityDTOS.forEach(k->priorityVOS.add(k.clone(PriorityVO.class)));
        return priorityVOS;
    }

    /**
     * 新增权限
     *
     * @param priorityDTO 权限
     * @return
     */
    @PostMapping("/")
    public Boolean savePriority(@RequestBody PriorityDTO priorityDTO){
        return priorityService.savePriority(priorityDTO.clone(PriorityDTO.class));
    }

    /**
     * 通过id获取权限
     *
     * @param id ID
     * @return 权限
     */
    @GetMapping("/{id}")
    public PriorityVO getPriorityById(@RequestParam Long id){
        PriorityDTO priorityDTO = priorityService.getPriorityById(id);

        return priorityDTO.clone(PriorityVO.class);
    }

    /**
     * 更新权限
     *
     * @param priorityVO 权限DO
     * @return
     */
    @PutMapping("/{id}}")
    public Boolean updatePriority(@RequestBody PriorityVO priorityVO){
        return priorityService.updatePriority(priorityVO.clone(PriorityDTO.class));
    }
}
