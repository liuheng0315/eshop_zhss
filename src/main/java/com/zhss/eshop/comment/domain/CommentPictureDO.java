package com.zhss.eshop.comment.domain;

import lombok.Data;

import java.util.Date;

/**
 * 评论晒图
 * @author zhonghuashishan
 *
 */
@Data
public class CommentPictureDO {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 评论信息id
	 */
	private Long commentInfoId;
	/**
	 * 评论图片路径
	 */
	private String commentPicturePath;
	/**
	 * 评论晒图的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 评论晒图的修改时间
	 */
	private Date gmtModified;
}
