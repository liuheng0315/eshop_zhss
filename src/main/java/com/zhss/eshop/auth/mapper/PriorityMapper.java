package com.zhss.eshop.auth.mapper;

import com.zhss.eshop.auth.domain.PriorityDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 权限管理模块的mapper组件
 *
 * @author liuheng
 */
@Mapper
public interface PriorityMapper {
    /**
     * 查询根权限的列表
     * @return 根权限集合
     */
    @Select("select id,code,url,priority_comment,priority_type,priority_id,parent_id,gmt_create,gmt_modified " +
            "from auth_priority where parent_id is null")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "code", property = "code"),
            @Result(column = "url", property = "url"),
            @Result(column = "priority_comment", property = "priorityComment"),
            @Result(column = "priority_type", property = "priorityType"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modified", property = "gmtModified")
    })
    List<PriorityDO> listRootPriorities();

    /**
     * 查询子权限
     * @param parentId 父权限ID
     * @return 子权限
     */
    @Select("select id,code,url,priority_comment,priority_type,priority_id,parent_id,gmt_create,gmt_modified " +
            "from auth_priority where parent_id = #{parentId}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "code", property = "code"),
            @Result(column = "url", property = "url"),
            @Result(column = "priority_comment", property = "priorityComment"),
            @Result(column = "priority_type", property = "priorityType"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modified", property = "gmtModified")
    })
    List<PriorityDO> listChildPriorities(@Param("parentId") Long parentId);

    /**
     * 新增权限
     * @param priorityDO
     */
    @Insert("insert into auth_priority(code,url,priority_comment,priority_type,parent_id,gmt_create,gmt_modified) " +
            "values (#{p.code},#{url},#{p.priorityComment},#{p.priorityType},#{p.parentId}," +
            "#{p.gmtCreate},#{p.gmtModified})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void savePriority(@Param("p") PriorityDO priorityDO);

    /**
     * 根据权限ID查询权限
     * @param id 权限ID
     * @return
     */
    @Select("select id,code,url,priority_comment,priority_type,priority_id,parent_id,gmt_create,gmt_modified " +
            "from auth_priority where id = #{id}")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "code", property = "code"),
            @Result(column = "url", property = "url"),
            @Result(column = "priority_comment", property = "priorityComment"),
            @Result(column = "priority_type", property = "priorityType"),
            @Result(column = "parent_id", property = "parentId"),
            @Result(column = "gmt_create", property = "gmtCreate"),
            @Result(column = "gmt_modified", property = "gmtModified")
    })
    PriorityDO getPriorityById(@Param("id") Long id);

    /**
     * 更新权限
     * @param priorityDO
     */
    @Update("update auth_priority set code=#{p.code},url=#{p.url},priority_comment=#{p.priority_comment}," +
            "parent_id=#{p.parent_id},gmt_create=#{p.gmtCreate},gmt_modified=#{p.gmtModified} " +
            "where id = #{p.id}")
    void updatePriority(@Param("p") PriorityDO priorityDO);
}
