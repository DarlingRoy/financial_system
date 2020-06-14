package com.example.financial_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Operation)实体类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:09
 */
@Data
@ApiModel("$tableInfo.comment")
public class Operation implements Serializable {
    private static final long serialVersionUID = 952401008061523856L;
    /**
    * 权限id
    */    
    @ApiModelProperty("权限id")
    private Integer id;
    /**
    * 权限名称
    */    
    @ApiModelProperty("权限名称")
    private String name;
    /**
    * url
    */    
    @ApiModelProperty("url")
    private String url;

}