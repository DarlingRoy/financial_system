package com.example.financial_system.vo;

import com.example.financial_system.entity.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: linqx
 * @Date: 2020/6/15 20:52
 */
@Data
public class OrderVO extends Order {

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 产品名
     */
    @ApiModelProperty("产品名")
    private String productName;

    /**
     * 订单类型名
     */
    @ApiModelProperty("订单类型名")
    private String orderTypeName;
}
