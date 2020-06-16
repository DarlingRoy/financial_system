package com.example.financial_system.dto;

import com.example.financial_system.common.entity.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: linqx
 * @date: 2020/6/16 20:37
 */
@Data
@ApiModel("可选请求类")
public class ProviderDTO extends PageRequest {

    /**
     * 排序指定字段，1为id，2为名字
     */
    @ApiModelProperty("（可选）排序指定字段，1为id，2为名字 ")
    private Integer orderFlag;

    /**
     * 模糊搜索关键字
     */
    @ApiModelProperty("（可选）模糊搜索关键字")
    private String keyword;
}
