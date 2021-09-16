package com.ledao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ledao.entity.User;
import com.ledao.entity.UserRole;

import java.util.List;

/**
 * @author LeDao
 * @company
 * @create 2021-09-16 12:52
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 根据用户id获取用户的角色
     *
     * @param userId
     * @return
     */
    List<UserRole> findByUserId(Integer userId);
}
