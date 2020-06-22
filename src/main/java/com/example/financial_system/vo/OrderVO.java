package com.example.financial_system.vo;

import com.example.financial_system.entity.Order;
import com.example.financial_system.service.ProductService;
import com.example.financial_system.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * OrderVO 展示类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Data
public class OrderVO extends Order {

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 产品名
     */
    @ApiModelProperty("产品名")
    private String productName;

    /**
     * 订单类型名
     */
    @ApiModelProperty("订单类型名")
    private String orderTypeName;

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public void convert(Order order) {
        if (userService.queryById(order.getUserId()) != null) {
            this.setUsername(userService.queryById(order.getUserId()).getUsername());
        }
        if (productService.queryById(this.getProductId()) != null) {
            this.setProductName(productService.queryById(order.getProductId()).getName());
        }
        if (order.getOrderType() != null) {
            this.setOrderTypeName(order.getOrderType() == 1 ? "出售" : "购买");
        }
    }


}
