package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.common.utils.SystemUtils;
import com.example.financial_system.entity.Order;
import com.example.financial_system.entity.User;
import com.example.financial_system.entity.UserProduct;
import com.example.financial_system.service.OrderService;
import com.example.financial_system.service.ProductService;
import com.example.financial_system.service.UserProductService;
import com.example.financial_system.service.UserService;
import com.example.financial_system.vo.UserProductVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author: linqx
 * @date: 2020/6/17 08:31
 */
@Api(tags = "客户端接口")
@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserProductService userProductService;

    /**
     * 注册操作
     * @param user
     * @return
     */
    @ApiOperation(value = "注册用户")
    @PostMapping("register")
    public JsonResult register(User user) {
        this.userService.insertSelective(user);
        return ResultTool.success();
    }

    /**
     * 购买产品
     */
    @ApiOperation(value = "购买产品")
    @PostMapping("buy")
    public JsonResult buy(@ApiParam (value = "productId") Integer productId,
                          @ApiParam (value = "amount") Integer amount) {
        // 插入订单
        Order order = new Order();
        order.setProductId(productId);
        order.setAmount(amount);
        Integer currentUserId = userService.queryByUsername(SystemUtils.getCurrentUserName()).getId();
        order.setUserId(currentUserId);
        order.setOrderTime(Calendar.getInstance().getTime());
        order.setOrderType(0);
        orderService.insertSelective(order);
        //更新用户产品表, 要根据 id 更新
        UserProduct userProduct = userProductService.queryByUserIdAndProductId(currentUserId, productId);
        Integer holdingShare = userProduct.getHoldingShare();
        userProduct.setHoldingShare(holdingShare + amount);
        userProductService.update(userProduct);
        return ResultTool.success();
    }

    /**
     *  查询当前用户所有的订单
     */
    @ApiOperation(value = "查询当前用户所有的订单")
    @GetMapping("allOrders")
    public JsonResult allOrders() {
        Integer currentUserId = userService.queryByUsername(SystemUtils.getCurrentUserName()).getId();
        return ResultTool.success(this.orderService.queryByUserId(currentUserId));
    }

    /**
     * 查询当前用户的产品列表
     */
    @ApiOperation(value = "查询当前用户的产品列表")
    @GetMapping("productList")
    public JsonResult productList() {
        Integer currentUserId = userService.queryByUsername(SystemUtils.getCurrentUserName()).getId();
        List<UserProduct> userProductList = this.userProductService.queryByUserId(currentUserId);
        List<UserProductVO> userProductVOList = new ArrayList<>();
        for (UserProduct userProduct: userProductList) {
            UserProductVO userProductVO = new UserProductVO();
            userProductVO.setProductName(this.productService.queryById(userProduct.getProductId()).getName());
            userProductVO.setAmountOccupied(userProduct.getHoldingShare());
            userProductVO.setTotalReturn(userProduct.getCumulativeIncome());
            userProductVOList.add(userProductVO);
        }
        return ResultTool.success(userProductVOList);
    }
}
