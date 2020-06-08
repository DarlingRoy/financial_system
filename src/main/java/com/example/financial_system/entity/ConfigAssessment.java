package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (ConfigAssessment)实体类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
@Data
@ApiModel("$tableInfo.comment")
public class ConfigAssessment implements Serializable {
    private static final long serialVersionUID = -80066744397411873L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer config;
        
    @ApiModelProperty("$column.comment")
    private Integer grade;
        
    @ApiModelProperty("$column.comment")
    private String description;
        
    @ApiModelProperty("$column.comment")
    private Integer operator;
        
    @ApiModelProperty("$column.comment")
    private Date assessTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}