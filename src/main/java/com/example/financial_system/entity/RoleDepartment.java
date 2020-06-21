package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 角色-部门(RoleDepartment)实体类
 *
 * @author linqx
 * @since 2020-06-21 11:26:35
 */
@Data
@ApiModel("角色-部门")
public class RoleDepartment implements Serializable {
    private static final long serialVersionUID = -64020137190053825L;
    /**
    * 角色-部门中间表id
    */    
    @ApiModelProperty("角色-部门中间表id")
    private Integer id;
    /**
    * 部门id
    */    
    @ApiModelProperty("部门id")
    private Integer departmentId;
    /**
    * 角色id
    */    
    @ApiModelProperty("角色id")
    private Integer roleId;
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