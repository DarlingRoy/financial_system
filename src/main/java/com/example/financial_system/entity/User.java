package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (User)实体类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:39
 */
@Data
@ApiModel("$tableInfo.comment")
public class User implements Serializable {
    private static final long serialVersionUID = 235340578594477820L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer departmentId;
        
    @ApiModelProperty("$column.comment")
    private String username;
        
    @ApiModelProperty("$column.comment")
    private String password;
        
    @ApiModelProperty("$column.comment")
    private String email;
        
    @ApiModelProperty("$column.comment")
    private String phone;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}