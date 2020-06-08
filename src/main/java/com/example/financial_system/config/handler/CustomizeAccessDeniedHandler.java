package com.example.financial_system.config.handler;

import com.alibaba.fastjson.JSON;
import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.enums.ResultCode;
import com.example.financial_system.common.utils.ResultTool;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizeAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {

        //用户没有权限，禁止访问,状态码403
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);

        //返回json数据
        JsonResult result= ResultTool.fail(ResultCode.NO_PERMISSION);
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
