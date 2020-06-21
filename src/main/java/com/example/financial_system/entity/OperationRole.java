package com.example.financial_system.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 权限-角色(OperationRole)实体类
 *
 * @author linqx
 * @since 2020-06-21 11:26:35
 */
@Data
@ApiModel("权限-角色")
public class OperationRole implements Serializable {
    private static final long serialVersionUID = -87929039653849998L;
        
    @ApiModelProperty("$column.comment")
    private Integer id;
        
    @ApiModelProperty("$column.comment")
    private Integer operationId;
        
    @ApiModelProperty("$column.comment")
    private Integer roleId;
        
    @ApiModelProperty("$column.comment")
    private Date createTime;
        
    @ApiModelProperty("$column.comment")
    private Boolean isDelete;

}