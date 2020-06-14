package com.example.financial_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (ProductType)实体类
 *
 * @author laidilin
 * @since 2020-06-15 00:10:06
 */
@Data
@ApiModel("$tableInfo.comment")
public class ProductType implements Serializable {
    private static final long serialVersionUID = 647741414206704601L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private String type;

}