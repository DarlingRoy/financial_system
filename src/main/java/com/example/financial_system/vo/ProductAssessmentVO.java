package com.example.financial_system.vo;

import com.example.financial_system.entity.ProductAssessment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: linqx
 * @Date: 2020/6/16 17:34
 */
@Data
public class ProductAssessmentVO extends ProductAssessment {

    /**
     * 产品名称
     */
    @ApiModelProperty("产品名称")
    private String productName;

    /**
     * 评价人员id
     */
    @ApiModelProperty("评价人名字")
    private String assessorName;

}
