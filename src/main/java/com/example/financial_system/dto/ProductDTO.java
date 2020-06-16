package com.example.financial_system.dto;

import com.example.financial_system.common.entity.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: linqx
 * @date: 2020/6/16 21:46
 */
@ApiModel(value = "产品模糊查询")
@Data
public class ProductDTO extends PageRequest {

    /**
     * 关键字，用于产品名称的模糊查询
     */
    @ApiModelProperty(value = "关键字")
    private String keyword;

    /**
     * 供应商id
     */
    @ApiModelProperty(value = "供应商id")
    private Integer providerId;

    /**
     * 产品类型id
     */
    @ApiModelProperty(value = "产品类型id")
    private Integer typeId;

    /**
     * 产品风险评级
     */
    @ApiModelProperty(value = "产品风险评级")
    private Integer riskLevel;

    /**
     * 产品状态
     */
    @ApiModelProperty(value = "产品状态")
    private Integer state;

    /**
     * 排序指定字段，1为id，2为名字, 3为产品类型id，4为产品风险评级，5为产品状态，6为入库时间
     */
    @ApiModelProperty("（可选）排序指定字段，1为id，2为名字, 3为产品类型id，4为产品风险评级，5为产品状态，6为入库时间 ")
    private Integer orderFlag;

}
