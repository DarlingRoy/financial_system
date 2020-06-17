package com.example.financial_system.common.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: linqx
 * @Date: 2020/6/14 15:14
 */
@RestControllerAdvice
public class MyExceptionHandler {


//    @ExceptionHandler(value = Exception.class)
//    public String exceptionHandler(Exception e){
//        JsonResult result = ResultTool.fail(ResultCode.COMMON_FAIL);
//        result.setData(e.getMessage());
//        return JSON.toJSONString(result);
//    }

}

