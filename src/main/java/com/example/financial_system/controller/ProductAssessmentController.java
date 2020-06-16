package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.ProductAssessment;
import com.example.financial_system.service.ProductAssessmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 产品评价(ProductAssessment)表控制层
 *
 * @author linqx
 * @since 2020-06-16 16:27:07
 */
@Api(tags = "产品评价(ProductAssessment)") 
@RestController
@RequestMapping("productAssessment")
public class ProductAssessmentController {
    /**
     * 服务对象
     */
    @Autowired
    private ProductAssessmentService productAssessmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 产品评价")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "产品评价id ID") Integer id) {
        return ResultTool.success(this.productAssessmentService.queryById(id));
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param productAssessment 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(ProductAssessment productAssessment){
        this.productAssessmentService.insertSelective(productAssessment);
        return ResultTool.success();
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param productAssessment 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(ProductAssessment productAssessment){
        this.productAssessmentService.insert(productAssessment);
        return ResultTool.success();
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param productAssessment 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(ProductAssessment productAssessment){
        this.productAssessmentService.update(productAssessment);
        return ResultTool.success();
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "产品评价id ID") Integer id){
        this.productAssessmentService.deleteById(id);
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
        return ResultTool.success(this.productAssessmentService.queryAll());
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @ApiOperation(value = "返回表中行数")
     @GetMapping("count")
     public JsonResult count() {
        return ResultTool.success(this.productAssessmentService.count());
     }

}