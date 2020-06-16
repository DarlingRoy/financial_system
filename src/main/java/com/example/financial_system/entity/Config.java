package com.example.financial_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 配置(Config)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("配置")
public class Config implements Serializable {
    private static final long serialVersionUID = -53339466743038985L;
    /**
    * 产品id
    */    
    @ApiModelProperty("产品id")
    private Integer id;
    /**
    * 子产品列表
    */    
    @ApiModelProperty("子产品列表")
    private String subProductList;

}