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

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("产品名")
    private String productName;
}
