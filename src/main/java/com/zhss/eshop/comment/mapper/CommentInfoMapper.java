package com.zhss.eshop.comment.mapper;

import com.zhss.eshop.comment.domain.CommentInfoDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * @author : liu heng
 * @description : 评论mapper组件
 * @date : 2021-05-06 23:21
 **/
@Mapper
public interface CommentInfoMapper {
    /**
     * 插入评论信息
     * @param commentInfoDO 评论信息对象
     */
    @Insert("insert into comment_info (user_account_id,username,order_info_id,order_item_id,goods_id,goods_sku_id," +
            "goods_sku_sale_properties,total_score,goods_score,customer_service_score,logistics_score,comment_content," +
            "is_show_pictures,is_default_comment,comment_status,comment_type,gmt_create,gmt_modified) values " +
            "(#{userAccountId},#{username},#{orderInfoId},#{orderItemId},#{goodsId},#{goodsSkuId}," +
            "#{goodsSkuSaleProperties},#{totalScore},#{goodsScore},#{customerServiceScore}," +
            "#{commentContent},#{isShowPictures},#{isDefaultComment},#{commentStatus},#{commentType}," +
            "#{gmtCreate},#{gmtModified})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void saveCommentInfo(CommentInfoDO commentInfoDO);
}
