package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Config)实体类
 *
 * @author laidilin
 * @since 2020-06-11 23:48:03
 */
@Data
@ApiModel("$tableInfo.comment")
public class Config implements Serializable {
    private static final long serialVersionUID = 173412403444154335L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer provider;
        
    @ApiModelProperty("$column.comment")
    private String name;
        
    @ApiModelProperty("$column.comment")
    private Integer product1Id;
        
    @ApiModelProperty("$column.comment")
    private Integer product2Id;
        
    @ApiModelProperty("$column.comment")
    private Integer product3Id;
        
    @ApiModelProperty("$column.comment")
    private Double price;
        
    @ApiModelProperty("$column.comment")
    private String discount;
        
    @ApiModelProperty("$column.comment")
    private Integer quota;
        
    @ApiModelProperty("$column.comment")
    private Date publishTime;
        
    @ApiModelProperty("$column.comment")
    private Date stopIssuingTime;
        
    @ApiModelProperty("$column.comment")
    private Double rateOfReturn;
        
    @ApiModelProperty("$column.comment")
    private Double startUpPoint;
        
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