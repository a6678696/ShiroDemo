package com.ledao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author LeDao
 * @company
 * @create 2021-09-16 11:03
 */
@Data
@TableName(value = "t_user")
public class User {

    /**
     * 编号
     */
    @TableId
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "userName")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 昵称
     */
    @TableField(value = "nickName")
    private String nickName;
}
