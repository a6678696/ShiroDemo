package com.ledao.controller;

import com.ledao.entity.User;
import com.ledao.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author LeDao
 * @company
 * @create 2021-09-16 19:32
 */
@Controller
@RequestMapping("/user")
public class UserController {

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
     * 登录
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public ModelAndView login(User user, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        User currentUser = userService.findByUserName(user.getUserName());
        if (currentUser != null) {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), getEncodePassword("md5", user.getPassword(), currentUser.getSalt(), 2));
            try {
                subject.login(token);
                session.setAttribute("currentUser", currentUser);
                mav.setViewName("index");
            } catch (AuthenticationException e) {//登录失败
                e.printStackTrace();
                mav.addObject("error", "用户名或密码错误!!");
                mav.addObject("user", user);
                mav.setViewName("login");
            }
        } else {//用户不存在
            mav.addObject("error", "用户名或密码错误!!");
            mav.addObject("user", user);
            mav.setViewName("login");
        }
        return mav;
    }

    /**
     * 添加学生
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addStudent")
    @RequiresPermissions(value = "添加学生")
    public String addStudent() {
        return "添加学生成功";
    }

    /**
     * 添加教师
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/addTeacher")
    @RequiresPermissions(value = "添加教师")
    public String addTeacher() {
        return "添加教师成功";
    }

    /**
     * 获取md5加密后的密码
     *
     * @param encryptName 加密算法名称
     * @param password    加密前的密码
     * @param salt        盐值
     * @param times       加密次数
     * @return
     */
    private static String getEncodePassword(String encryptName, String password, String salt, Integer times) {
        return new SimpleHash(encryptName, password, salt, times).toString();
    }
}
