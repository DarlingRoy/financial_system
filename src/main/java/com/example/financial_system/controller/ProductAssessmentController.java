package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.common.utils.SystemUtils;
import com.example.financial_system.entity.Product;
import com.example.financial_system.entity.ProductAssessment;
import com.example.financial_system.service.ProductAssessmentService;
import com.example.financial_system.service.ProductService;
import com.example.financial_system.service.UserService;
import com.example.financial_system.vo.ProductAssessmentVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @ApiOperation(value = "根据id查询 产品评价")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "产品评价id ID") Integer id) {
        ProductAssessment productAssessment = this.productAssessmentService.queryById(id);
        ProductAssessmentVO productAssessmentVO = mapper.map(productAssessment, ProductAssessmentVO.class);
        productAssessmentVO.setAssessorName(userService.queryById(productAssessment.getOperatorId()).getUsername());
        productAssessmentVO.setProductName(productService.queryById(productAssessment.getProductId()).getName());
        return ResultTool.success(productAssessmentVO);
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param productAssessment 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(ProductAssessment productAssessment){
        String username = SystemUtils.getCurrentUserName();
        productAssessment.setOperatorId(userService.queryByUsername(username).getId());
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
        String username = SystemUtils.getCurrentUserName();
        productAssessment.setOperatorId(userService.queryByUsername(username).getId());
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
        List<ProductAssessment> productAssessmentList = this.productAssessmentService.queryAll();
        List<ProductAssessmentVO> productAssessmentVOList = new ArrayList<>();
        for (ProductAssessment productAssessment: productAssessmentList) {
            ProductAssessmentVO productAssessmentVO = mapper.map(productAssessment, ProductAssessmentVO.class);
            productAssessmentVO.setAssessorName(userService.queryById(productAssessment.getOperatorId()).getUsername());
            productAssessmentVO.setProductName(productService.queryById(productAssessment.getProductId()).getName());
            productAssessmentVOList.add(productAssessmentVO);
        }
        return ResultTool.success(productAssessmentVOList);
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