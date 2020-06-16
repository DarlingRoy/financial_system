package com.example.financial_system.controller;

import com.example.financial_system.VO.ProductAssessmentVO;
import com.example.financial_system.VO.ProductVO;
import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.entity.PageRequest;
import com.example.financial_system.common.utils.PageUtils;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.Product;
import com.example.financial_system.entity.ProductAssessment;
import com.example.financial_system.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * (Product)表控制层
 *
 * @author linqx
 * @since 2020-06-15 21:34:48
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
     * dozer mapper 类
     */
    @Autowired
    private Mapper mapper;

    @Autowired
    private ProductAssessmentService productAssessmentService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private UserService userService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "产品id ID") Integer id) {
        Product product = this.productService.queryById(id);
        ProductVO productVO = mapper.map(product, ProductVO.class);
        productVO.setProviderName(providerService.queryById(productVO.getProviderId()).getName());
        productVO.setProductType(productTypeService.queryById(productVO.getProductTypeId()).getType());
        productVO.setReviewOperatorName(userService.queryById(productVO.getReviewOperatorId()).getUsername());
        return ResultTool.success(productVO);
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
    public JsonResult delete(@ApiParam(value = "产品id ID") Integer id){
        this.productService.deleteById(id);
        return ResultTool.success();
    }


    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "查询表中所有数据")
    @GetMapping("selectAll")
    public JsonResult selectAll(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Product> productList = productService.queryAll();
        List<ProductVO> productVOList = new ArrayList<>();
        for (Product product: productList) {
            ProductVO productVO = mapper.map(product, ProductVO.class);
            productVO.setProviderName(providerService.queryById(product.getProviderId()).getName());
            productVO.setProductType(productTypeService.queryById(product.getProductTypeId()).getType());
            productVO.setReviewOperatorName(userService.queryById(product.getReviewOperatorId()).getUsername());
            productVOList.add(productVO);
        }
        return ResultTool.success(PageUtils. getPageResult(new PageInfo<>(productVOList)));
    }

    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    @ApiOperation(value = "返回表中行数")
    @GetMapping("count")
    public JsonResult count() {
        return ResultTool.success(this.productService.count());
    }

    /**
     * 审核操作
     * @param id 被审核产品id
     * @param reviewResult 审核结果
     * @param reviewText 审核备注
     * @return JsonResult 的成功样式
     */
    @ApiOperation(value = "审核产品")
    @PostMapping("review")
    public JsonResult review(@ApiParam (value = "被审核产品id") Integer id,
                             @ApiParam (value = "审核结果") String reviewResult,
                             @ApiParam (value = "审核备注") String reviewText) {
        Product product = new Product();
        product.setId(id);
        product.setReviewResult(reviewResult);
        product.setReviewText(reviewText);
        this.productService.update(product);
        return ResultTool.success();
    }

    @ApiOperation(value = "评估产品")
    @PostMapping("assess")
    public JsonResult assess(@ApiParam (value = "被评估产品id") Integer id,
                             @ApiParam (value = "评估结果 A,B,C") String assessResult,
                             @ApiParam (value = "评估文本") String assessText) {
        ProductAssessment productAssessment = new ProductAssessment();
        productAssessment.setProductId(id);
        productAssessment.setAssessResult(assessResult);
        productAssessment.setAssessText(assessText);
        this.productAssessmentService.insertSelective(productAssessment);
        return ResultTool.success();
    }

    @ApiOperation(value = "获取产品评估结果")
    @GetMapping("getAssessments")
    public JsonResult getAssessments(@ApiParam (value = "被评估产品id") Integer id) {
        List<ProductAssessment> productAssessmentList = this.productAssessmentService.queryByProductId(id);
        List<ProductAssessmentVO> productAssessmentVOList = new ArrayList<>();
        for (ProductAssessment productAssessment: productAssessmentList) {
            ProductAssessmentVO productAssessmentVO = new ProductAssessmentVO();
            productAssessmentVO.setAssessResult(productAssessment.getAssessResult());
            productAssessmentVO.setAssessText(productAssessment.getAssessText());
            productAssessmentVO.setAssessTime(productAssessment.getAssessTime());
            productAssessmentVO.setAssessorName(userService.queryById(productAssessment.getOperatorId()).getUsername());
            productAssessmentVOList.add(productAssessmentVO);
        }
        return ResultTool.success(productAssessmentVOList);
    }


}
