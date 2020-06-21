package com.example.financial_system.vo;

import com.example.financial_system.entity.UserProduct;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: linqx
 * @date: 2020/6/17 11:27
 */
@ApiModel(value = "用户产品展示类")
@Data
public class UserProductVO extends UserProduct {

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String productName;

    /**
     * 用户持有产品份额
     */
    @ApiModelProperty(value = "持有产品份额")
    private Integer amountOccupied;

    /**
     * 累计收益
     */
    @ApiModelProperty(value = "累计收益")
    private Double totalReturn;
}
