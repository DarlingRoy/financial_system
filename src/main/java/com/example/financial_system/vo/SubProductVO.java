package com.example.financial_system.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: linqx
 * @date: 2020/6/21 14:34
 */
@Data
public class SubProductVO {
    /**
     * 产品id
     */
    @ApiModelProperty(value = "产品id")
    private Integer productId;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /**
     * 产品收益率
     */
    @ApiModelProperty(value = "产品收益率")
    private Double returnRate;
}
