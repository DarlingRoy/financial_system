package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.common.utils.SystemUtils;
import com.example.financial_system.entity.Order;
import com.example.financial_system.service.OrderService;
import com.example.financial_system.service.ProductService;
import com.example.financial_system.service.UserService;
import com.example.financial_system.vo.OrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * (Order)表控制层
 *
 * @author laidilin
 * @since 2020-06-14 23:40:09
 */
@Api(tags = "(Order)")
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderService orderService;

    /**
     * Dozer mapper 类
     */
    @Autowired
    private Mapper mapper;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "订单id ID") Integer id) {
        Order order = this.orderService.queryById(id);
        OrderVO orderVO = mapper.map(order, OrderVO.class);
        orderVO.setUsername(userService.queryById(orderVO.getUserId()).getUsername());
        orderVO.setProductName(productService.queryById(orderVO.getProductId()).getName());
        return ResultTool.success(orderVO);
    }

    /**
     * 增加一条记录(只填入不为空的字段)
     * @param order 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(Order order){
        order.setUserId(userService.queryByUsername(SystemUtils.getCurrentUserName()).getId());
        this.orderService.insertSelective(order);
        return ResultTool.success();
    }

    /**
     * 增加一条记录(填入所有字段)
     * @param order 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(Order order){
        order.setUserId(userService.queryByUsername(SystemUtils.getCurrentUserName()).getId());
        this.orderService.insert(order);
        return ResultTool.success();
    }

    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param order 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PostMapping("update")
    public JsonResult update(Order order){
        this.orderService.update(order);
        return ResultTool.success();
    }

    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "订单id ID") Integer id){
        this.orderService.deleteById(id);
        return ResultTool.success();
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "查询表中所有数据")
    @GetMapping("selectAll")
    public JsonResult selectAll() {
        List<Order> orderList = this.orderService.queryAll();
        List<OrderVO> orderVOList = new ArrayList<OrderVO>();
        for (Order order: orderList) {
            OrderVO orderVO = mapper.map(order, OrderVO.class);
            orderVO.setUsername(userService.queryById(orderVO.getUserId()).getUsername());
            orderVO.setProductName(productService.queryById(orderVO.getProductId()).getName());
            orderVOList.add(orderVO);
        }
        return ResultTool.success(orderVOList);
    }

}
