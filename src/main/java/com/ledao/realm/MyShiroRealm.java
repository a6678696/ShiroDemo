package com.ledao.realm;

import com.ledao.entity.*;
import com.ledao.service.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

/**
 * 自定义Realm
 *
 * @author LeDao
 * @company
 * @create 2021-09-16 11:44
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RoleService roleService;

    @Resource
    private RolePermissionService rolePermissionService;

    @Resource
    private PermissionService permissionService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //获取已登录用户的用户名
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //控制台打印用户名
        System.out.println(userName);
        //获取用户的id
        Integer userId = userService.findByUserName(userName).getId();
        //查询该用户的所有角色
        List<UserRole> userRoleList = userRoleService.findByUserId(userId);
        //如果该用户拥有角色
        if (userRoleList.size() > 0) {
            for (UserRole userRole : userRoleList) {
                //获取当前角色实体
                Role role = roleService.findById(userRole.getRoleId());
                //向Shiro添加角色的名称
                simpleAuthorizationInfo.addRole(role.getRole());
                //控制台打印角色的名称
                System.out.println(role.getRole());
                //获取该角色的全部权限
                List<RolePermission> rolePermissionList = rolePermissionService.findByRoleId(role.getId());
                if (rolePermissionList.size() > 0) {
                    for (RolePermission rolePermission : rolePermissionList) {
                        //获取当前权限实体
                        Permission permission = permissionService.findById(rolePermission.getPermissionId());
                        //向Shiro添加权限的名称
                        simpleAuthorizationInfo.addStringPermission(permission.getPermission());
                        //控制台打印权限的名称
                        System.out.println(permission.getPermission());
                    }
                }
            }
        }
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        User user = userService.findByUserName(userName);
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
        } else {
            return null;
        }
    }
}
