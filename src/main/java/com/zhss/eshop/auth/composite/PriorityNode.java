package com.zhss.eshop.auth.composite;

import com.zhss.eshop.auth.visitor.PriorityNodeVisitor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : liu heng
 * @description :
 * @date : 2021-04-28 12:55
 **/
@Data
public class PriorityNode {
    /**
     * id
     */
    private Long id;
    /**
     * 编号
     */
    private String code;
    /**
     * 权限url
     */
    private String url;
    /**
     * 权限备注
     */
    private String priorityComment;
    /**
     * 权限类型
     */
    private Integer priorityType;
    /**
     * 父权限id
     */
    private Long parentId;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 更新时间
     */
    private Date gmtModified;

    private List<PriorityNode> children = new ArrayList<>();

    /**
     * 接受一个权限树的访问者
     * @param visitor
     */
    public void accept(PriorityNodeVisitor visitor) {
        visitor.visit(this);
    }
}
