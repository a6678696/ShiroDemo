package com.ledao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ledao.entity.Permission;
import com.ledao.mapper.PermissionMapper;
import com.ledao.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LeDao
 * @company
 * @create 2021-09-16 13:41
 */
@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper,Permission> implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public Permission findById(Integer id) {
        return permissionMapper.selectById(id);
    }
}
