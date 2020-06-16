package com.example.financial_system.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 产品类型(ProductType)实体类
 *
 * @author linqx
 * @since 2020-06-16 15:50:26
 */
@Data
@ApiModel("产品类型")
public class ProductType implements Serializable {
    private static final long serialVersionUID = 200499097499142396L;
    /**
    * 产品类型id
    */    
    @ApiModelProperty("产品类型id")
    private Integer id;
    /**
    * 产品类型
    */    
    @ApiModelProperty("产品类型")
    private String type;

}