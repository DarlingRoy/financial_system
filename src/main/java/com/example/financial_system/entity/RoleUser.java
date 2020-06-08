package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * (RoleUser)实体类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:39
 */
@Data
@ApiModel("$tableInfo.comment")
public class RoleUser implements Serializable {
    private static final long serialVersionUID = 928702689715147050L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer userId;
        
    @ApiModelProperty("$column.comment")
    private Integer roleId;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Integer isDelete;

}