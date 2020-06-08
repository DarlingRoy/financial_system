package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (ProductAccessment)实体类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
@Data
@ApiModel("$tableInfo.comment")
public class ProductAccessment implements Serializable {
    private static final long serialVersionUID = 205849581479986782L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer product;
        
    @ApiModelProperty("$column.comment")
    private Integer grade;
        
    @ApiModelProperty("$column.comment")
    private String desc;
        
    @ApiModelProperty("$column.comment")
    private Integer operator;
        
    @ApiModelProperty("$column.comment")
    private Date assessTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}