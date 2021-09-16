package com.ledao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ledao.entity.Role;

/**
 * @author LeDao
 * @company
 * @create 2021-09-16 12:59
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据id获取角色
     *
     * @param id
     * @return
     */
    Role findById(Integer id);
}
