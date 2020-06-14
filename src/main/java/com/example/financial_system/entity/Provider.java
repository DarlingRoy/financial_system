package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Provider)实体类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:28
 */
@Data
@ApiModel("$tableInfo.comment")
public class Provider implements Serializable {
    private static final long serialVersionUID = 904462096715340068L;
    /**
    * 供应商id
    */    
    @ApiModelProperty("供应商id")
    private Integer id;
    /**
    * 供应商名称
    */    
    @ApiModelProperty("供应商名称")
    private String name;
    /**
    * 邮件
    */    
    @ApiModelProperty("邮件")
    private String email;
    /**
    * 电话
    */    
    @ApiModelProperty("电话")
    private String phone;
    /**
    * 地址
    */    
    @ApiModelProperty("地址")
    private String address;
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