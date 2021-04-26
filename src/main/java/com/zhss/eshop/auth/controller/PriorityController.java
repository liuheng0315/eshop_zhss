package com.zhss.eshop.auth.controller;

import com.zhss.eshop.auth.domain.PriorityVO;
import com.zhss.eshop.auth.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 权限管理模块的controller组件
 * @author liuheng
 */
@RestController
@RequestMapping("/auth")
public class PriorityController {
    @Autowired
    private PriorityService priorityService;

    /**
     * 查询根权限
     * @return 权限列表
     */
    @GetMapping("/priority/root")
    List<PriorityVO> listRootPriorities(){
        return null;
    }
}
