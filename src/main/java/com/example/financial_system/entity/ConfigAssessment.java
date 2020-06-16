package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 配置评价(ConfigAssessment)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("配置评价")
public class ConfigAssessment implements Serializable {
    private static final long serialVersionUID = 913421224387843394L;
    /**
    * 配置评价id
    */    
    @ApiModelProperty("配置评价id")
    private Integer id;
    /**
    * 配置id
    */    
    @ApiModelProperty("配置id")
    private Integer configId;
    /**
    * 配置评估等级
    */    
    @ApiModelProperty("配置评估等级")
    private String grade;
    /**
    * 评价内容
    */    
    @ApiModelProperty("评价内容")
    private String description;
    /**
    * 评价人员id
    */    
    @ApiModelProperty("评价人员id")
    private Integer operatorId;
    /**
    * 评价时间
    */    
    @ApiModelProperty("评价时间")
    private Date assessTime;
    /**
    * 逻辑删除
    */    
    @ApiModelProperty("逻辑删除")
    private Boolean isDelete;

}