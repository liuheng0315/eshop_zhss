package com.zhss.eshop.auth.controller;

import com.zhss.eshop.auth.domain.PriorityDTO;
import com.zhss.eshop.auth.domain.PriorityVO;
import com.zhss.eshop.auth.service.PriorityService;
import com.zhss.eshop.common.util.DateProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private DateProvider dateProvider;

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

    /**
     * 根据父权限id查询子权限
     * @param parentId 父权限id
     * @return 子权限
     */
    @GetMapping("/child/{parentId}")
    public List<PriorityVO> listChildPriorities(
            @PathVariable("parentId") Long parentId) {
        try {
            List<PriorityDTO> priorityDTOs = priorityService.listChildPriorities(parentId);
            if(priorityDTOs == null) {
                priorityDTOs = new ArrayList<PriorityDTO>();
            }

            List<PriorityVO> priorityVOs = new ArrayList<PriorityVO>(priorityDTOs.size());
            for(PriorityDTO priorityDTO : priorityDTOs) {
                priorityVOs.add(convertPriorityDTO2VO(priorityDTO));
            }

            return priorityVOs;
        } catch (Exception e) {
            log.error("error", e);
        }
        return new ArrayList<PriorityVO>();
    }

    /**
     * 根据id查询权限
     * @param id 权限id
     * @return 权限
     */
    @GetMapping("/{id}")
    public PriorityVO getPriorityById(@PathVariable("id") Long id) {
        try {
            PriorityDTO priorityDTO = priorityService.getPriorityById(id);
            if(priorityDTO == null) {
                priorityDTO = new PriorityDTO();
            }

            return convertPriorityDTO2VO(priorityDTO);
        } catch (Exception e) {
            log.error("error", e);
        }
        return new PriorityVO();
    }

    /**
     * 查询账号被授权的权限树
     * @param accountId 账号id
     * @return 权限树
     */
    @GetMapping("/authorized/tree/{accountId}")
    public List<PriorityDTO> listAuthorizedTree(
            @PathVariable("accountId") Long accountId) {
        try {
            return priorityService.listAuthorizedByAccountId(accountId);
        } catch (Exception e) {
            log.error("error", e);
            return new ArrayList<PriorityDTO>();
        }
    }

    /**
     * 判断账号对指定编号的权限是否有授权记录
     * @param accountId 账号id
     */
    @GetMapping("/authorized/code/{accountId}")
    public Boolean existAuthorizedByCode(
            @PathVariable("accountId") Long accountId,
            String code) {
        try {
            return priorityService.existAuthorizedByCode(accountId, code);
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
    }

    /**
     * 判断账号对指定url的权限是否有授权记录
     * @param accountId 账号id
     */
    @GetMapping("/authorized/url/{accountId}")
    public Boolean existAuthorizedByUrl(
            @PathVariable("accountId") Long accountId,
            String url) {
        try {
            return priorityService.existAuthorizedByUrl(accountId, url);
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
    }

    /**
     * 新增权限
     * @param priorityVO 权限DO对象
     */
    @PostMapping("/")
    public Boolean savePriority(@RequestBody PriorityVO priorityVO) {
        try {
            priorityService.savePriority(convertPriorityVO2DTO(priorityVO));
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
        return true;
    }

    /**
     * 更新权限
     * @param priorityVO 权限DO对象
     */
    @PutMapping("/{id}")
    public Boolean updatePriority(@RequestBody PriorityVO priorityVO) {
        try {
            priorityService.updatePriority(convertPriorityVO2DTO(priorityVO));
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
        return true;
    }

    /**
     * 删除权限
     */
    @DeleteMapping("/{id}")
    public Boolean removePriority(@PathVariable("id") Long id) {
        try {
            return priorityService.removePriority(id);
        } catch (Exception e) {
            log.error("error", e);
        }
        return false;
    }

    /**
     * 将权限DTO对象转换为VO对象
     * @param priorityDTO
     * @return
     * @throws Exception
     */
    private PriorityVO convertPriorityDTO2VO(PriorityDTO priorityDTO) throws Exception {
        PriorityVO priorityVO = priorityDTO.clone(PriorityVO.class);
        priorityVO.setGmtCreate(dateProvider.formatDatetime(priorityDTO.getGmtCreate()));
        priorityVO.setGmtModified(dateProvider.formatDatetime(priorityDTO.getGmtModified()));
        return priorityVO;
    }

    /**
     * 将权限VO对象转换为DTO对象
     * @param priorityVO
     * @return
     * @throws Exception
     */
    private PriorityDTO convertPriorityVO2DTO(PriorityVO priorityVO) throws Exception {
        PriorityDTO priorityDTO = priorityVO.clone(PriorityDTO.class);
        if(priorityVO.getGmtCreate() != null) {
            priorityDTO.setGmtCreate(dateProvider.parseDatetime(priorityVO.getGmtCreate()));
        }
        if(priorityVO.getGmtModified() != null) {
            priorityDTO.setGmtModified(dateProvider.parseDatetime(priorityVO.getGmtModified()));
        }
        return priorityDTO;
    }
}
