package com.ledao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 权限实体类
 *
 * @author LeDao
 * @company
 * @create 2021-09-16 11:18
 */
@Data
@TableName(value = "t_permission")
public class Permission {

    /**
     * 编号
     */
    @TableId
    private Integer id;

    /**
     * 权限名称
     */
    private String permission;
}
