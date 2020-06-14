package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Department)实体类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:09
 */
@Data
@ApiModel("$tableInfo.comment")
public class Department implements Serializable {
    private static final long serialVersionUID = 537464938558626364L;
    /**
    * 部门id
    */    
    @ApiModelProperty("部门id")
    private Integer id;
    /**
    * 部门名称
    */    
    @ApiModelProperty("部门名称")
    private String name;
    /**
    * 部门类型
    */    
    @ApiModelProperty("部门类型")
    private String type;
    /**
    * 创建时间
    */    
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
    * 是否删除
    */    
    @ApiModelProperty("是否删除")
    private Boolean isDelete;

}