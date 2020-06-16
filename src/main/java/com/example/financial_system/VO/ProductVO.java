package com.example.financial_system.VO;

import com.example.financial_system.entity.Product;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: linqx
 * @Date: 2020/6/15 20:51
 */
@Data
public class ProductVO extends Product {

    @ApiModelProperty("产品名称")
    private String providerName;

    @ApiModelProperty("产品类型")
    private String productType;

    @ApiModelProperty("审核人员名称")
    private String reviewOperatorName;
}
