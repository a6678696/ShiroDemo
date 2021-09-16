package com.ledao;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author LeDao
 * @company
 * @create 2021-09-14 11:10
 */
public class Test {

    public static void main(String[] args) {
        //原始密码
        String password = "admin";
        //随机盐值
        String salt = "uDCwdPYvZmym7WBNvsgh4Q==";
        System.out.println(salt);
        //加密次数
        int times = 2;
        //加密算法
        String encryptName = "md5";
        //加密后的密码
        String encodePassword = new SimpleHash(encryptName, password, salt, times).toString();
        System.out.println(encodePassword);
    }
}
