package com.example.financial_system.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: linqx
 * @Date: 2020/6/16 10:32
 */
@Data
public class PageRequest {
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
