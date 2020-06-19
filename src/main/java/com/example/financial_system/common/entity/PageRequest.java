package com.example.financial_system.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: linqx
 * @Date: 2020/6/16 10:32
 */
@Data
@ApiModel("分页请求类")
public class PageRequest implements Serializable{

    private static final long serialVersionUID = 8094420604588359404L;
    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码")
    private int pageNum;

    /**
     * 每页数量
     */
    @ApiModelProperty(value = "每页数量")
    private int pageSize;
}
