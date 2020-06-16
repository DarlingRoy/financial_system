package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 角色-用户(RoleUser)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("角色-用户")
public class RoleUser implements Serializable {
    private static final long serialVersionUID = 273512765438096015L;
    /**
    * 角色-用户id
    */    
    @ApiModelProperty("角色-用户id")
    private Integer id;
    /**
    * 用户id
    */    
    @ApiModelProperty("用户id")
    private Integer userId;
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
    * 逻辑删除
    */    
    @ApiModelProperty("逻辑删除")
    private Integer isDelete;

}