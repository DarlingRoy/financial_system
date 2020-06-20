package com.example.financial_system.vo;

import com.example.financial_system.entity.ConfigAssessment;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: linqx
 * @date: 2020/6/21 07:17
 */
@Data
@ApiModel(value = "配置评价")
public class ConfigAssessmentVO {
    private static final long serialVersionUID = 913421224387843394L;
    /**
     * 配置评价id
     */
    @ApiModelProperty("配置评价id")
    private Integer id;
    /**
     * 配置id
     */
    @ApiModelProperty("配置id")
    private Integer configId;
    /**
     * 配置评估等级
     */
    @ApiModelProperty("配置评估等级")
    private String grade;
    /**
     * 评价内容
     */
    @ApiModelProperty("评价内容")
    private String description;
    /**
     * 评价人员姓名
     */
    @ApiModelProperty("评价人员姓名")
    private String operatorName;
    /**
     * 评价时间
     */
    @ApiModelProperty("评价时间")
    private Date assessTime;
    /**
     * 逻辑删除
     */
    @ApiModelProperty("逻辑删除")
    private Boolean isDelete;
}
