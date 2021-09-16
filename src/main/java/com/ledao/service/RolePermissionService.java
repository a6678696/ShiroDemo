package com.ledao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ledao.entity.RolePermission;

import java.util.List;

/**
 * @author LeDao
 * @company
 * @create 2021-09-16 13:08
 */
public interface RolePermissionService extends IService<RolePermission> {

    /**
     * 根据角色id获取该角色的所有权限
     *
     * @param roleId
     * @return
     */
    List<RolePermission> findByRoleId(Integer roleId);
}
