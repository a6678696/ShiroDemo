package com.ledao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ledao.entity.Role;
import com.ledao.mapper.RoleMapper;
import com.ledao.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author LeDao
 * @company
 * @create 2021-09-16 13:00
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role findById(Integer id) {
        return roleMapper.selectById(id);
    }
}
