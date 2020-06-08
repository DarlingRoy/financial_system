package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Order)实体类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
@Data
@ApiModel("$tableInfo.comment")
public class Order implements Serializable {
    private static final long serialVersionUID = -73970314657671771L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer user;
        
    @ApiModelProperty("$column.comment")
    private Integer repository;
        
    @ApiModelProperty("$column.comment")
    private Integer count;
        
    @ApiModelProperty("$column.comment")
    private Double price;
        
    @ApiModelProperty("$column.comment")
    private Double amount;
        
    @ApiModelProperty("$column.comment")
    private Integer operator;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}