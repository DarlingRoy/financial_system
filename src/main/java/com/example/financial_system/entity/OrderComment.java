package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 订单评价(OrderComment)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("订单评价")
public class OrderComment implements Serializable {
    private static final long serialVersionUID = 621803642270207896L;
    /**
    * 订单评价id
    */    
    @ApiModelProperty("订单评价id")
    private Integer id;
    /**
    * 订单id
    */    
    @ApiModelProperty("订单id")
    private Integer orderId;
    /**
    * 订单评分
    */    
    @ApiModelProperty("订单评分")
    private Integer grade;
    /**
    * 订单评价描述
    */    
    @ApiModelProperty("订单评价描述")
    private String desc;
    /**
    * 评价人员id
    */    
    @ApiModelProperty("评价人员id")
    private Integer operatorId;
    /**
    * 评价时间
    */    
    @ApiModelProperty("评价时间")
    private Date commentTime;
    /**
    * 逻辑删除
    */    
    @ApiModelProperty("逻辑删除")
    private Boolean isDelete;

}