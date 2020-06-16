package com.example.financial_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 权限(Operation)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("权限")
public class Operation implements Serializable {
    private static final long serialVersionUID = 423286600598182029L;
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