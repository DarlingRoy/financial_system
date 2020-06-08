package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Product)实体类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
@Data
@ApiModel("$tableInfo.comment")
public class Product implements Serializable {
    private static final long serialVersionUID = 400640438700854920L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer providerId;
        
    @ApiModelProperty("$column.comment")
    private String name;
        
    @ApiModelProperty("$column.comment")
    private String type;
        
    @ApiModelProperty("$column.comment")
    private String status;
        
    @ApiModelProperty("$column.comment")
    private Double pricr;
        
    @ApiModelProperty("$column.comment")
    private Double rateOfReturn;
        
    @ApiModelProperty("$column.comment")
    private Double startUpPoint;
        
    @ApiModelProperty("$column.comment")
    private Date duration;
        
    @ApiModelProperty("$column.comment")
    private Date due;
        
    @ApiModelProperty("$column.comment")
    private Integer riskLevel;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Date reviewTime;
        
    @ApiModelProperty("$column.comment")
    private Integer createOperator;
        
    @ApiModelProperty("$column.comment")
    private Integer reviewOperator;

}