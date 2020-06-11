package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Product)实体类
 *
 * @author laidilin
 * @since 2020-06-11 21:29:53
 */
@Data
@ApiModel("$tableInfo.comment")
public class Product implements Serializable {
    private static final long serialVersionUID = -61552594003739139L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer productTypeId;
        
    @ApiModelProperty("$column.comment")
    private String name;
        
    @ApiModelProperty("$column.comment")
    private Double price;
    /**
    * 产品额度
    */    
    @ApiModelProperty("产品额度")
    private Integer quota;
        
    @ApiModelProperty("$column.comment")
    private Double rateOfReturn;
        
    @ApiModelProperty("$column.comment")
    private Double startUpPoint;
        
    @ApiModelProperty("$column.comment")
    private Date publishTime;
    /**
    * 停止发行时间
    */    
    @ApiModelProperty("停止发行时间")
    private Date stopIssuingTime;
    /**
    * 定期理财产品的天数
    */    
    @ApiModelProperty("定期理财产品的天数")
    private Integer duration;
        
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

    @ApiModelProperty("产品对应的供应商ID")
    private Integer providerId;

    @ApiModelProperty("产品对应的供应商名称")
    private String providerName;

    @ApiModelProperty("产品对应类型名称")
    private String type;

}