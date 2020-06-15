package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Product)实体类
 *
 * @author linqx
 * @since 2020-06-15 23:43:39
 */
@Data
@ApiModel("$tableInfo.comment")
public class Product implements Serializable {
    private static final long serialVersionUID = -74916479352952231L;
    /**
    * 产品id
    */    
    @ApiModelProperty("产品id")
    private Integer id;
    /**
    * 供应商id
    */    
    @ApiModelProperty("供应商id")
    private Integer providerId;
    /**
    * 产品类型id
    */    
    @ApiModelProperty("产品类型id")
    private Integer productTypeId;
    /**
    * 产品名称
    */    
    @ApiModelProperty("产品名称")
    private String name;
    /**
    * 期长
    */    
    @ApiModelProperty("期长")
    private String duration;
    /**
    * 收益率
    */    
    @ApiModelProperty("收益率")
    private Double rateOfReturn;
    /**
    * 产品额度
    */    
    @ApiModelProperty("产品额度")
    private Integer totalAmount;
    /**
    * 剩余金额(0.4表示 0.4%）
    */    
    @ApiModelProperty("剩余金额(0.4表示 0.4%）")
    private Double remainAmount;
    /**
    * 起购金额
    */    
    @ApiModelProperty("起购金额")
    private Double leastAmount;
    /**
    * 风险评级（5个）
    */    
    @ApiModelProperty("风险评级（5个）")
    private Integer riskLevel;
    /**
    * 入库备注
    */    
    @ApiModelProperty("入库备注")
    private String addText;
    /**
    * 状态
    */    
    @ApiModelProperty("状态")
    private Integer state;
    /**
    * 入库时间
    */    
    @ApiModelProperty("入库时间")
    private Date storageTime;
    /**
    * 上架时间
    */    
    @ApiModelProperty("上架时间")
    private Date addedTime;
        
    @ApiModelProperty("$column.comment")
    private Integer reviewOperatorId;
    /**
    * 审核结果
    */    
    @ApiModelProperty("审核结果")
    private Boolean reviewResult;
    /**
    * 审核备注
    */    
    @ApiModelProperty("审核备注")
    private String reviewRemarks;

}