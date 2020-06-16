package com.example.financial_system.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: linqx
 * @Date: 2020/6/16 17:34
 */
@Data
public class ProductAssessmentVO {
    /**
     * 产品分数
     */
    @ApiModelProperty("产品评价等级")
    private String assessResult;
    /**
     * 评价文本
     */
    @ApiModelProperty("评价文本")
    private String assessText;
    /**
     * 评价人员id
     */
    @ApiModelProperty("评价人名字")
    private String assessorName;
    /**
     * 评价时间
     */
    @ApiModelProperty("评价时间")
    private Date assessTime;
}
