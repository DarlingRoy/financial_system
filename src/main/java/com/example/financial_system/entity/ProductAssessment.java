package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 产品评价(ProductAssessment)实体类
 *
 * @author linqx
 * @since 2020-06-16 16:27:07
 */
@Data
@ApiModel("产品评价")
public class ProductAssessment implements Serializable {
    private static final long serialVersionUID = -11146438851848518L;
    /**
    * 产品评价id
    */    
    @ApiModelProperty("产品评价id")
    private Integer id;
    /**
    * 产品id
    */    
    @ApiModelProperty("产品id")
    private Integer productId;
    /**
    * 产品分数
    */    
    @ApiModelProperty("产品分数")
    private String assessResult;
    /**
    * 评价文本
    */    
    @ApiModelProperty("评价文本")
    private String assessText;
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