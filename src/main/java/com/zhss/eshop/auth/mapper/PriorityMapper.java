package com.zhss.eshop.auth.mapper;

import com.zhss.eshop.auth.domain.PriorityDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author : liu heng
 * @description :
 * @date : 2023-04-13 00:04
 **/
@Mapper
public interface PriorityMapper {
    /**
     * 查询根权限
     * @return 权限集合
     */
    @Select("select id,code,url,priority_comment,priority_type,parent_id,gmt_create,gmt_modified " +
            "from auth_priority WHERE parent_id is NULL")
    List<PriorityDO> listRootPriorities();

    /**
     * 根据id查询权限
     * @param parentId 父权限id
     * @return 权限
     */
    @Select("select id,code,url,priority_comment,priority_type,parent_id,gmt_create,gmt_modified " +
            "from auth_priority where parent_id = #{parentId}")
    List<PriorityDO> listChildPriorities(@Param("parentId") Long parentId);

    /**
     * 根据id查询权限
     * @param id 权限id
     * @return 权限
     */
    @Select("SELECT "
            + "id,"
            + "code,"
            + "url,"
            + "priority_comment,"
            + "priority_type,"
            + "parent_id,"
            + "gmt_create,"
            + "gmt_modified "
            + "FROM auth_priority "
            + "WHERE id = #{id}")
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
     * 查询账号被授权的根菜单
     * @param map 查询参数
     * @return 菜单
     */
    @Select("<script>" +
            "select * from ( " +
            "select * from auth_account_role_relationship acr " +
            "join auth_role_priority_relationship rpr on acr.role_id = rpr.role_id " +
            "join auth_priority p on rpr.priority_id = p.id " +
            "where acr.account_id = #{accountId} " +
            "<if test='parentId == null'> and p.parent_id is null and p.priority_type = 1 </if>" +
            "<if test='parentId != null'> and p.parent_id = #{parentId} </if> " +
            "union all " +
            "select * from auth_account_priority_relationship apr " +
            "join auth_priority p on apr.priority_id = p.id " +
            "where acr.account_id = #{accountId} " +
            "<if test='parentId == null'> and p.parent_id is null and p.priority_type = 1 </if>" +
            "<if test='parentId != null'> and p.parent_id = #{parentId} </if> " +
            ")" +
            "</script>")
    List<PriorityDO> listAuthorizedByAccountId(@Param("parameters") Map<String, Object> map);

    /**
     * 根据权限编号判断账号是否有对这个权限有授权记录
     * @param accountId 账号id
     * @param code 权限编码
     * @return 是否有授权记录
     */
    @Select("select sum(cnt) from (" +
            "select count(*) cnt from auth_account_role_relationship arr " +
            "join auth_role_priority_relationship rpr on arr.role_id=rpr.role_id " +
            "join auth_priority p on rpr.priority_id=p.id " +
            "where arr.account_id = #{accountId} " +
            "and p.code = #{code} " +
            "union all " +
            "select count(*) cnt from auth_account_priority_relationship apr " +
            "join auth_priority p on apr.priority_id=p.id " +
            "where apr.account_id = #{accountId} " +
            "and p.code = #{code}" +
            ")")
    Long countAuthorizedByCode(@Param("accountId") Long accountId, @Param("code") String code);

    /**
     * 根据权限URL判断账号是否对这个权限有授权记录
     * @param accountId 账号id
     * @param url 权限url
     * @return 是否有授权记录
     */
    @Select("SELECT SUM(cnt) "
            + "FROM "
            + "("
            + "SELECT count(*) cnt "
            + "FROM auth_account_role_relationship arr "
            + "JOIN auth_role_priority_relationship rpr ON arr.role_id=rpr.role_id "
            + "JOIN auth_priority p ON rpr.priority_id=p.id "
            + "WHERE arr.account_id=#{accountId} "
            + "AND p.url=#{url} "
            + "UNION ALL "
            + "SELECT count(*) cnt "
            + "FROM auth_account_priority_relationship apr "
            + "JOIN auth_priority p ON apr.priority_id=p.id "
            + "WHERE apr.account_id=#{accountId} "
            + "AND p.url=#{url} "
            + ") a "
    )
    Long countAuthorizedByUrl(@Param("accountId") Long accountId, @Param("url") String url);

    /**
     * 根据权限id查询账号id
     * @param priorityId 权限id
     * @return 有该权限的账号id集合
     */
    @Select("SELECT account_id "
            + "FROM ("
            + "SELECT arr.account_id "
            + "FROM auth_account_role_relationship arr "
            + "JOIN auth_role_priority_relationship rpr ON arr.role_id=rpr.role_id "
            + "WHERE rpr.priority_id=#{priorityId} "

            + "UNION ALL "

            + "SELECT apr.account_id "
            + "FROM auth_account_priority_relationship apr "
            + "WHERE apr.priority_id=#{priorityId} "
            + ") a ")
    List<Long> listAccountIdsByPriorityId(@Param("priorityId") Long priorityId);

    /**
     * 新增权限
     * @param priorityDO 权限DO对象
     */
    @Insert("INSERT INTO auth_priority("
            + "code, "
            + "url, "
            + "priority_comment, "
            + "priority_type, "
            + "parent_id, "
            + "gmt_create, "
            + "gmt_modified"
            + ") "
            + "VALUES("
            + "#{code}, "
            + "#{url}, "
            + "#{priorityComment}, "
            + "#{priorityType}, "
            + "#{parentId}, "
            + "#{gmtCreate}, "
            + "#{gmtModified}"
            + ")")
    @Options(keyColumn = "id", keyProperty = "id", useGeneratedKeys = true)
    void savePriority(PriorityDO priorityDO);

    /**
     * 更新权限
     * @param priorityDO 权限DO对象
     */
    @Update("UPDATE auth_priority SET "
            + "code=#{code}, "
            + "url=#{url}, "
            + "priority_comment=#{priorityComment}, "
            + "priority_type=#{priorityType}, "
            + "gmt_modified=#{gmtModified} "
            + "WHERE id=#{id}")
    void updatePriority(PriorityDO priorityDO);

    /**
     * 删除权限
     * @param id 权限id
     */
    @Delete("DELETE FROM auth_priority WHERE id=#{id}")
    void removePriority(@Param("id") Long id);
}
