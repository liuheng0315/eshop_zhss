package com.zhss.eshop.comment.controller;

import com.zhss.eshop.comment.constant.ShowPictures;
import com.zhss.eshop.comment.domain.CommentInfo;
import com.zhss.eshop.comment.domain.CommentInfoDTO;
import com.zhss.eshop.comment.domain.CommentInfoVO;
import com.zhss.eshop.comment.service.CommentInfoService;
import com.zhss.eshop.comment.service.CommentPictureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : liu heng
 * @description : 评论管理模块的Controller组件
 * @date : 2021-05-06 23:15
 **/
@RestController
@RequestMapping("/comment")
@Slf4j
public class CommentController {
    @Autowired
    private CommentInfoService commentInfoService;

    /**
     * 评论晒图管理模块的service组件
     */
    @Autowired
    private CommentPictureService commentPictureService;
    /**
     * 手动发表评论
     * @param commentInfoVO 评论信息的VO对象
     * @param files 文件
     * @return 处理结果
     */
    @PostMapping("/")
    public Boolean publishComment(HttpServletRequest request,
                                  CommentInfoVO commentInfoVO, MultipartFile[] files) {
        try {
            // 为评论设置是否晒图
            Integer showPictures = ShowPictures.NO;
            if(files != null && files.length > 0) {
                for(MultipartFile file : files) {
                    if(file != null) {
                        showPictures = ShowPictures.YES;
                        break;
                    }
                }
            }
            commentInfoVO.setIsShowPictures(showPictures);

            // 保存评论信息
            CommentInfoDTO commentInfoDTO = commentInfoVO.clone(CommentInfoDTO.class);
            commentInfoService.saveCommentInfo(commentInfoDTO);

            //上传评论晒图的图片
            // 上传评论晒图图片
            String appBasePath = request.getSession().getServletContext().getRealPath("/");
            commentPictureService.saveCommentPictures(appBasePath, commentInfoDTO.getId(), files);
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
        return true;
    }
}
