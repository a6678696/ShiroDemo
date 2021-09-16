package com.ledao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色权限实体类
 * 用于绑定角色和权限,即:某个角色有什么权限
 *
 * @author LeDao
 * @company
 * @create 2021-09-16 11:19
 */
@Data
@TableName(value = "t_role_permission")
public class RolePermission {

    /**
     * 编号
     */
    @TableId
    private Integer id;

    /**
     * 角色id
     */
    @TableField(value = "roleId")
    private Integer roleId;

    /**
     * 权限id
     */
    @TableField(value = "permissionId")
    private Integer permissionId;
}
