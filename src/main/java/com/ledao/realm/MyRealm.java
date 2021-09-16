package com.ledao.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 自定义Realm实现认证和授权
 *
 * @author LeDao
 * @company
 * @create 2021-09-15 19:49
 */
public class MyRealm extends AuthorizingRealm {

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.getPrimaryPrincipal();
        //获取角色
        Set<String> roles = getRolesByUserName(userName);
        //获取权限
        Set<String> permissions = getPermissionsByUserName(userName);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken 从主体传过来的认证信息
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从主体传过来的认证信息中获得用户名
        String userName = (String) authenticationToken.getPrincipal();
        //根据用户名获取密码
        String password = getPasswordByUserName(userName);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, password, "myRealm");
        return simpleAuthenticationInfo;
    }

    /**
     * 存储用户的用户名和密码,用于模拟数据库
     */
    Map<String, String> userMap = new HashMap<>(16);

    {
        //加入一个用户名为ledao,密码为123456的用户
        userMap.put("ledao", "123456");
        //设置自定义Realm的名称,取什么无所谓
        super.setName("myRealm");
    }

    /**
     * 模拟从数据库根据用户名获取密码
     *
     * @param userName 用户名
     * @return
     */
    private String getPasswordByUserName(String userName) {
        return userMap.get(userName);
    }

    /**
     * 模拟从数据库中根据用户名获取角色数据
     *
     * @param userName 用户名
     * @return
     */
    private Set<String> getRolesByUserName(String userName) {
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("teacher");
        return roles;
    }

    /**
     * 拟从数据库中根据用户名获取权限数据
     *
     * @param userName 用户名
     * @return
     */
    private Set<String> getPermissionsByUserName(String userName) {
        Set<String> permissions = new HashSet<>();
        permissions.add("添加学生");
        permissions.add("添加教师");
        return permissions;
    }
}
