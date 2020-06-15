package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Order)实体类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:09
 */
@Data
@ApiModel("$tableInfo.comment")
public class Order implements Serializable {
    private static final long serialVersionUID = -27217555622232133L;
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
    * 下单时间
    */
    @ApiModelProperty("下单时间")
    private Date orderTime;
    /**
    * 到期时间
    */
    @ApiModelProperty("到期时间")
    private Date expireTime;
    /**
    * 购买金额
    */
    @ApiModelProperty("购买金额")
    private Double purchasePrice;
    /**
    * 逻辑删除
    */
    @ApiModelProperty("逻辑删除")
    private Boolean isDelete;

}