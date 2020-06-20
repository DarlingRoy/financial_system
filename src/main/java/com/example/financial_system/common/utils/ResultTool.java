package com.example.financial_system.common.utils;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.enums.ResultCode;

public class ResultTool {
    public static JsonResult success(){
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data){
        return new JsonResult<>(true,data);
    }

    public static JsonResult fail(){
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }

    public static JsonResult fail(String errorMsg){
        return new JsonResult(false, errorMsg);
    }
}
