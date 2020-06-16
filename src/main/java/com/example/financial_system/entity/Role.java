package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 角色(Role)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("角色")
public class Role implements Serializable {
    private static final long serialVersionUID = 736852136356643997L;
    /**
    * 角色id
    */    
    @ApiModelProperty("角色id")
    private Integer id;
    /**
    * 角色名称
    */    
    @ApiModelProperty("角色名称")
    private String name;
    /**
    * 角色类型
    */    
    @ApiModelProperty("角色类型")
    private String type;
    /**
    * 角色状态
    */    
    @ApiModelProperty("角色状态")
    private String status;
    /**
    * 角色创建时间
    */    
    @ApiModelProperty("角色创建时间")
    private Date createTime;
    /**
    * 逻辑删除
    */    
    @ApiModelProperty("逻辑删除")
    private Boolean isDelete;

}