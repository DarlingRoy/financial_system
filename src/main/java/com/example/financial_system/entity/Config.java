package com.example.financial_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (Config)实体类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:08
 */
@Data
@ApiModel("$tableInfo.comment")
public class Config implements Serializable {
    private static final long serialVersionUID = -44518455439061612L;
    /**
    * 产品id
    */    
    @ApiModelProperty("产品id")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private String subProductList;

}