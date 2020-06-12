package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.Product;
import com.example.financial_system.service.ProductService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Product)表控制层
 *
 * @author laidilin
 * @since 2020-06-11 21:29:53
 */
@Api(tags = "(Product)") 
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Autowired
    private ProductService productService;

    /**
     * 根据产品id，查询产品所有信息、产品对应供应商的id和名称、以及产品对应的类型
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据产品id，查询产品所有信息、产品对应供应商的id和名称、以及产品对应的类型 ")
    @GetMapping("selectOne")
    public Product selectOne(@ApiParam(value = " ID") Integer id) {
        return this.productService.queryById(id);
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param product 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(Product product){
        this.productService.insertSelective(product);
        return ResultTool.success();
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param product 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(Product product){
        this.productService.insert(product);
        return ResultTool.success();
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param product 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(Product product){
        this.productService.update(product);
        return ResultTool.success();
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = " ID") Integer id){
        this.productService.deleteById(id);
        return ResultTool.success();
    }
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @ApiOperation(value = "根据起始位置和查询条数查询多条数据")
    @GetMapping("selectAllByLimit")   
    public List<Product> selectAllByLimit(@ApiParam(value = "查询起始位置") int offset,@ApiParam(value = "查询记录条数") int limit) {
        return this.productService.queryAllByLimit(offset, limit);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "查询表中所有数据")
    @GetMapping("selectAll")   
    public List<Product> selectAll() {
        return this.productService.queryAll();
    }


}