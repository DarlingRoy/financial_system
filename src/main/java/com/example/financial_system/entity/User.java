package com.example.financial_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户(User)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("用户")
@JsonIgnoreProperties(value = {"password", "createTime", "isDelete"})
public class User implements Serializable {
    private static final long serialVersionUID = -35279123583447742L;
    /**
    * 用户id
    */    
    @ApiModelProperty("用户id")
    private Integer id;
    /**
    * 部门id
    */    
    @ApiModelProperty("部门id")
    private Integer departmentId;
    /**
    * 用户名
    */    
    @ApiModelProperty("用户名")
    private String username;
    /**
    * 用户密码
    */    
    @ApiModelProperty("用户密码")
    private String password;
    /**
    * 邮箱
    */    
    @ApiModelProperty("邮箱")
    private String email;
    /**
    * 电话号码
    */    
    @ApiModelProperty("电话号码")
    private String phone;
    /**
    * 余额
    */    
    @ApiModelProperty("余额")
    private Integer balance;
    /**
    * 创建时间
    */    
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
    * 逻辑删除
    */    
    @ApiModelProperty("逻辑删除")
    private Boolean isDelete;

}