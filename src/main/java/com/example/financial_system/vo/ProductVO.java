package com.example.financial_system.vo;

import com.example.financial_system.entity.Product;
import com.example.financial_system.entity.ProductAssessment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author: linqx
 * @Date: 2020/6/15 20:51
 */
@Data
public class ProductVO extends Product {

    @ApiModelProperty("产品名称")
    private String providerName;

    @ApiModelProperty("产品类型名，有购买，出售")
    private String productType;

    @ApiModelProperty("审核人员名称")
    private String reviewOperatorName;


    @ApiModelProperty("产品的评估列表")
    private List<ProductAssessmentVO> productAssessments;

    @ApiModelProperty("产品的子产品列表")
    private List<SubProductVO> subProductVOList;
}
