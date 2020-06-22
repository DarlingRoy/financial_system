package com.example.financial_system.common.exception;

import com.alibaba.fastjson.JSON;
import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.enums.ResultCode;
import com.example.financial_system.common.utils.ResultTool;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: linqx
 * @Date: 2020/6/14 15:14
 */
@RestControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        JsonResult result = ResultTool.fail(ResultCode.COMMON_FAIL);
        result.setData(e.getMessage());
        e.printStackTrace();
        return JSON.toJSONString(result);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public String exceptionHandler(NullPointerException e) {
        JsonResult result = ResultTool.fail(ResultCode.NULL_POINTER);
        result.setData(e.getMessage());
        e.printStackTrace();
        return JSON.toJSONString(result);
    }

}

