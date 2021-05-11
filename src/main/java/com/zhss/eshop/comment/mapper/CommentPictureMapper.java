package com.zhss.eshop.comment.mapper;

import com.zhss.eshop.comment.domain.CommentPictureDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author : liu heng
 * @description : 评论晒图
 * @date : 2021-05-10 18:48
 **/
@Mapper
public interface CommentPictureMapper {
    /**
     * 新增评论晒图
     * @param commentPictureDO 评论晒图DO对象
     */
    @Insert("INSERT INTO comment_picture("
            + "comment_info_id,"
            + "comment_picture_path,"
            + "gmt_create,"
            + "gmt_modified"
            + ")"
            + "VALUES("
            + "#{commentInfoId},"
            + "#{commentPicturePath},"
            + "#{gmtCreate},"
            + "#{gmtModified}"
            + ")")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void saveCommentPicture(CommentPictureDO commentPictureDO);
}
