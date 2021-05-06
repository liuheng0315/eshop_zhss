package com.zhss.eshop.comment.controller;

import com.zhss.eshop.comment.domain.CommentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : liu heng
 * @description : 评论管理模块的Controller组件
 * @date : 2021-05-06 23:15
 **/
@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {
    /**
     * 手动发表评论
     * @param commentInfo 评论信息的VO对象
     * @return 处理结果
     */
    @PostMapping("/")
    public Boolean publishComment(@RequestBody CommentInfo commentInfo) {
        try {
            // 保存评论信息
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
        return true;
    }
}
