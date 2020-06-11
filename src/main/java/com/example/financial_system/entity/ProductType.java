package com.example.financial_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (ProductType)实体类
 *
 * @author laidilin
 * @since 2020-06-11 21:30:26
 */
@Data
@ApiModel("$tableInfo.comment")
public class ProductType implements Serializable {
    private static final long serialVersionUID = 723654395784981615L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private String type;

}