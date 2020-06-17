package com.example.financial_system.common.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: linqx
 * @date: 2020/6/17 08:49
 */
public class SystemUtils {


    public static String getCurrentUserName() {
        //根据 session 获取用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


}
