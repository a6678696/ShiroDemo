package com.ledao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ledao.entity.Permission;

/**
 * @author LeDao
 * @company
 * @create 2021-09-16 13:41
 */
public interface PermissionService extends IService<Permission> {

    /**
     * 根据id获取权限
     *
     * @param id
     * @return
     */
    Permission findById(Integer id);
}
