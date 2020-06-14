package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (ConfigAssessment)实体类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:08
 */
@Data
@ApiModel("$tableInfo.comment")
public class ConfigAssessment implements Serializable {
    private static final long serialVersionUID = -98725308444089656L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer config;
    /**
    * 产品评估等级
    */    
    @ApiModelProperty("产品评估等级")
    private String grade;
    /**
    * 评价内容
    */    
    @ApiModelProperty("评价内容")
    private String description;
        
    @ApiModelProperty("$column.comment")
    private Integer operatorId;
        
    @ApiModelProperty("$column.comment")
    private Date assessTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}