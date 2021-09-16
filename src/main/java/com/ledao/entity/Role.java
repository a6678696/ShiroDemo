package com.ledao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色实体类
 *
 * @author LeDao
 * @company
 * @create 2021-09-16 11:12
 */
@Data
@TableName(value = "t_role")
public class Role {

    /**
     * 编号
     */
    @TableId
    private Integer id;

    /**
     * 角色名称
     */
    private String role;
}
