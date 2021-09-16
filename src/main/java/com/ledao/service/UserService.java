package com.ledao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ledao.entity.User;

/**
 * @author LeDao
 * @company
 * @create 2021-09-16 11:56
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
