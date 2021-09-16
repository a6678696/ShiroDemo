package com.ledao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户角色实体
 * 用于绑定用户和角色,即:某个用户有什么角色
 *
 * @author LeDao
 * @company
 * @create 2021-09-16 11:15
 */
@Data
@TableName(value = "t_user_role")
public class UserRole {

    /**
     * 编号
     */
    @TableId
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "userId")
    private Integer userId;

    /**
     * 角色id
     */
    @TableField(value = "roleId")
    private Integer roleId;
}
