package com.example.financial_system.common.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: linqx
 * @Date: 2020/6/16 10:33
 */
@Data
public class PageResult {
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

    /**
     * 记录总数
     */
    @ApiModelProperty(value = "记录总数")
    private long totalSize;

    /**
     * 页码总数
     */
    @ApiModelProperty(value = "页码总数")
    private int totalPages;

    /**
     * 数据模型
     */
    @ApiModelProperty(value = "数据模型")
    private List<?> content;
}
