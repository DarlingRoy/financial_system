package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Repository)实体类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
@Data
@ApiModel("$tableInfo.comment")
public class Repository implements Serializable {
    private static final long serialVersionUID = -15079625219009309L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer productId;
        
    @ApiModelProperty("$column.comment")
    private Integer configId;
        
    @ApiModelProperty("$column.comment")
    private String status;
        
    @ApiModelProperty("$column.comment")
    private Integer stock;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}