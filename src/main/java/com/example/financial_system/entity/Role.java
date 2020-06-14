package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Role)实体类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:29
 */
@Data
@ApiModel("$tableInfo.comment")
public class Role implements Serializable {
    private static final long serialVersionUID = -83364834695404778L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private String name;
        
    @ApiModelProperty("$column.comment")
    private String type;
        
    @ApiModelProperty("$column.comment")
    private String status;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}