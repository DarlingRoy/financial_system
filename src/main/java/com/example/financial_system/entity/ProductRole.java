package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (ProductRole)实体类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
@Data
@ApiModel("$tableInfo.comment")
public class ProductRole implements Serializable {
    private static final long serialVersionUID = 492507937455551761L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer productId;
        
    @ApiModelProperty("$column.comment")
    private Integer roleId;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}