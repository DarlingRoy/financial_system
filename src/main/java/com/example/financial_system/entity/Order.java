package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 订单(Order)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("订单")
public class Order implements Serializable {
    private static final long serialVersionUID = 346881369738703742L;
    /**
    * 订单id
    */    
    @ApiModelProperty("订单id")
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
    * 金额
    */    
    @ApiModelProperty("金额")
    private Double amount;
    /**
    * 买入时间
    */    
    @ApiModelProperty("买入时间")
    private Integer orderType;
    /**
    * 卖出时间
    */    
    @ApiModelProperty("卖出时间")
    private Date orderTime;
    /**
    * 逻辑删除
    */    
    @ApiModelProperty("逻辑删除")
    private Boolean isDelete;

}