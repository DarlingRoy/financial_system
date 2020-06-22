package com.example.financial_system.vo;

import com.example.financial_system.entity.Order;
import com.example.financial_system.service.ProductService;
import com.example.financial_system.service.UserService;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: linqx
 * @Date: 2020/6/15 20:52
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

    public OrderVO convert(Order order) {
        OrderVO orderVO = mapper.map(order, OrderVO.class);
        if (userService.queryById(orderVO.getUserId()) != null) {
            orderVO.setUsername(userService.queryById(orderVO.getUserId()).getUsername());
        }
        if (productService.queryById(orderVO.getProductId()) != null) {
            orderVO.setProductName(productService.queryById(orderVO.getProductId()).getName());
        }
        if (order.getOrderType() != null) {
            orderVO.setOrderTypeName(order.getOrderType() == 1 ? "出售" : "购买");
        }
        return orderVO;
    }
}
