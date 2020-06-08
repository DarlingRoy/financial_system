package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Department)实体类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
@Data
@ApiModel("$tableInfo.comment")
public class Department implements Serializable {
    private static final long serialVersionUID = 986018735821513223L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private String name;
        
    @ApiModelProperty("$column.comment")
    private String type;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}