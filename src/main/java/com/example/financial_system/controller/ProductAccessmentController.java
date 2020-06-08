package com.example.financial_system.controller;

import com.example.financial_system.entity.ProductAccessment;
import com.example.financial_system.service.ProductAccessmentService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (ProductAccessment)表控制层
 *
 * @author laidilin
 * @since 2020-06-08 10:28:21
 */
@Api(tags = "(ProductAccessment)") 
@RestController
@RequestMapping("productAccessment")
public class ProductAccessmentController {
    /**
     * 服务对象
     */
    @Autowired
    private ProductAccessmentService productAccessmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public ProductAccessment selectOne(@ApiParam(value = " ID") Integer id) {
        return this.productAccessmentService.queryById(id);
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param productAccessment 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public void insertSelective(ProductAccessment productAccessment){
        this.productAccessmentService.insertSelective(productAccessment);
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param productAccessment 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public void insert(ProductAccessment productAccessment){
        this.productAccessmentService.insert(productAccessment);
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param productAccessment 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public void update(ProductAccessment productAccessment){
        this.productAccessmentService.update(productAccessment);
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public void delete(@ApiParam(value = " ID") Integer id){
        this.productAccessmentService.deleteById(id);
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
    public List<ProductAccessment> selectAllByLimit(@ApiParam(value = "查询起始位置") int offset,@ApiParam(value = "查询记录条数") int limit) {
        return this.productAccessmentService.queryAllByLimit(offset, limit);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "根据表中所有数据")
    @GetMapping("selectAll")   
    public List<ProductAccessment> selectAll() {
        return this.productAccessmentService.queryAll();
    }

}