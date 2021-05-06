package com.zhss.eshop.comment.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author : liu heng
 * @description : 评论图片
 * @date : 2021-05-06 22:31
 **/
@Data
public class CommentPicture {
    /**
     * id
     */
    private Long id;
    /**
     * 评论id
     */
    private Long commentInfoId;
    /**
     * 晒图路径
     */
    private String commentPicturePath;
    /**
     * 创建时间
     */
    private Date gmtCreat;
    /**
     * 修改时间
     */
    private Date gmtModify;
}
