package com.zhss.eshop.auth.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author : liu heng
 * @description : 角色权限关系管理模块的mapper组件
 * @date : 2021-04-28 22:33
 **/
@Mapper
public interface RolePriorityRelationshipMapper {
    /**
     * 根据权限ID查询记录数
     * @param priorityId 权限ID
     * @return 记录数
     */
    @Select("select count(*) from auth_role_priority_relationship where priority_id = #{priorityId}")
    Long getCountByPriorityId(@Param("priorityId") Long priorityId);
}
