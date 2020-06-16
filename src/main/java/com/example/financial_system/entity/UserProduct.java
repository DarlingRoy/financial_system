package com.example.financial_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 用户产品(UserProduct)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("用户产品")
public class UserProduct implements Serializable {
    private static final long serialVersionUID = -99021249556462092L;
    /**
    * 用户产品id
    */    
    @ApiModelProperty("用户产品id")
    private Integer id;
    /**
    * 用户id
    */    
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
    * 产品id
    */    
    @ApiModelProperty("产品id")
    private Integer productId;
    /**
    * 持有份额
    */    
    @ApiModelProperty("持有份额")
    private Integer holdingShare;
    /**
    * 累计收益
    */    
    @ApiModelProperty("累计收益")
    private Double cumulativeIncome;

}