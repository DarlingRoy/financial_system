package com.example.financial_system.config.handler;

import com.alibaba.fastjson.JSON;
import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.enums.ResultCode;
import com.example.financial_system.common.utils.ResultTool;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        //用户没有登录
        JsonResult result= ResultTool.fail(ResultCode.USER_NOT_LOGIN);

        //返回json数据
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));

    }
}
