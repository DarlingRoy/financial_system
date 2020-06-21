package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.common.utils.SystemUtils;
import com.example.financial_system.entity.Order;
import com.example.financial_system.entity.Product;
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
import org.springframework.transaction.annotation.Transactional;
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
        this.userService.clientRegister(user);
        return ResultTool.success();
    }

    /**
     * 购买产品
     */
    @ApiOperation(value = "购买产品")
    @PostMapping("buy")
    @Transactional
    public JsonResult buy(@ApiParam (value = "productId") Integer productId,
                          @ApiParam (value = "amount") Integer amount) {

        Product product = productService.queryById(productId);
        User user = userService.queryByUsername(SystemUtils.getCurrentUserName());

        if (product.getState() != 3){
            return ResultTool.fail("非在售产品");
        }

        //购买金额大于产品余额，购买失败
        if (amount > product.getRemainAmount()){
            return ResultTool.fail("产品余额不足");
        }

        //购买金额小于起购金额，购买失败
        if (amount < product.getLeastAmount()){
            return ResultTool.fail("所选额度小于起购金额");
        }

        //用户账户余额小于购买金额，购买失败
        if (user.getBalance() < amount){
            return ResultTool.fail("账户余额不足");
        }

        // 插入订单
        Order order = new Order();
        order.setProductId(productId);
        order.setAmount(amount);
        Integer currentUserId = user.getId();
        order.setUserId(currentUserId);
        order.setOrderTime(Calendar.getInstance().getTime());
        order.setOrderType(0);
        orderService.insertSelective(order);

        //更新用户产品表, 要根据 id 更新
        UserProduct userProduct = userProductService.queryByUserIdAndProductId(currentUserId, productId);
        if (userProduct != null){
            Integer holdingShare = userProduct.getHoldingShare();
            userProduct.setHoldingShare(holdingShare + amount);
            userProductService.update(userProduct);
        } else {
            //第一次购买该产品
            userProduct = new UserProduct();
            userProduct.setUserId(currentUserId);
            userProduct.setProductId(productId);
            userProduct.setHoldingShare(amount);
            userProduct.setCumulativeIncome(0.0);
            userProductService.insertSelective(userProduct);
        }

        //更新用户表，扣减账户余额
        user.setBalance(user.getBalance() - amount);
        userService.update(user);

        //更新产品表
        product.setRemainAmount(product.getRemainAmount() - amount);
        //如果剩余额度小于起购额度，则售罄
        if (product.getRemainAmount() < product.getLeastAmount()){
            product.setState(4);
        }
        productService.update(product);

        return ResultTool.success();
    }

    /**
     * 用户卖出产品,卖出有两个不同的逻辑，定期产品到期自动卖出，
     * 活期产品用户手动卖出，并且活期产品需要全部卖出，两种逻辑使用同一个接口
     * @param
     * @return
     */
    @ApiOperation(value = "用户卖出产品,卖出有两个不同的逻辑，定期产品到期自动卖出,\n"+
                            "活期产品用户手动卖出，并且活期产品需要全部卖出，两种逻辑使用同一个接口")
    @GetMapping("sell")
    @Transactional
    public JsonResult sell(@ApiParam (value = "产品id") Integer productId,
                           @ApiParam (value = "卖出的金额，这个金额是连同收益的金额，累计收益后端没有做计算") Integer amount){

        User user = userService.queryByUsername(SystemUtils.getCurrentUserName());
        Product product = productService.queryById(productId);
        UserProduct userProduct = userProductService.queryByUserIdAndProductId(user.getId(),productId);
        if (userProduct == null){
            return ResultTool.fail("没有持有该产品");
        }
        if (userProduct.getHoldingShare() < amount){
            return ResultTool.fail("用户产品持有额不足");
        }

        //修改用户表，增加当前用户的余额
        user.setBalance(user.getBalance()+amount);
        userService.update(user);

        //修改产品表，增加产品余额
        product.setRemainAmount(product.getRemainAmount() + amount);
        productService.update(product);

        //修改用户产品表，减少用户产品持有金额
        userProduct.setHoldingShare(userProduct.getHoldingShare() - amount);
        userProductService.update(userProduct);

        //修改订单表，新增一条卖出的记录
        Order order = new Order();
        order.setUserId(user.getId());
        order.setProductId(productId);
        order.setOrderType(1);
        order.setAmount(amount);
        order.setOrderTime(Calendar.getInstance().getTime());
        orderService.insertSelective(order);

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
