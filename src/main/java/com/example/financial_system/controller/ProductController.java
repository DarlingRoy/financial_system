package com.example.financial_system.controller;

import com.example.financial_system.common.utils.SystemUtils;
import com.example.financial_system.dto.ProductDTO;
import com.example.financial_system.entity.Config;
import com.example.financial_system.vo.ProductAssessmentVO;
import com.example.financial_system.vo.ProductVO;
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
import java.util.Calendar;
import java.util.HashMap;
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

    @Autowired
    private ConfigService configService;

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
        productVO.setProductAssessments(productAssessmentService.queryByProductId(id));
        if (product.getProductTypeId() == 1) {
            productVO.setSubProductList(configService.queryById(id).getSubProductList());
        }
        return ResultTool.success(productVO);
    }

    /**
     * 增加一条记录(只填入不为空的字段)
     * @param product 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(Product product, @RequestParam (required = false) String subProducts){
        if (product.getTotalAmount() != null) {
            product.setRemainAmount(Double.valueOf(product.getTotalAmount()));
        }
        product.setState(1);
        product.setAddedTime(Calendar.getInstance().getTime());
        if (product.getProductTypeId() != null && product.getProductTypeId() == 1){
            Config config = new Config();
            config.setId(product.getId());
            config.setSubProductList(subProducts);
            configService.insert(config);
        }

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
        //获取对应待审核产品的id
        Product product = productService.queryById(id);

        if (product == null){
            return ResultTool.fail("产品不存在");
        }

        //如果产品处于待审核状态，则进行审核
        if (product.getState() == 1){
            product.setReviewResult(reviewResult);
            product.setReviewText(reviewText);
            this.productService.update(product);
            return ResultTool.success();
        } else {
            return ResultTool.fail("产品已审核，不能重复审核");
        }

    }

    @ApiOperation(value = "评估产品")
    @PostMapping("assess")
    public JsonResult assess(@ApiParam (value = "被评估产品id") Integer id,
                             @ApiParam (value = "评估结果 A,B,C") String assessResult,
                             @ApiParam (value = "评估文本") String assessText) {
        Product product = productService.queryById(id);
        Integer state = product.getState();

        //通过审核的产品才可以评估
        if (state >= 2 && state <= 4) {
            ProductAssessment productAssessment = new ProductAssessment();
            productAssessment.setProductId(id);
            productAssessment.setAssessResult(assessResult);
            productAssessment.setAssessText(assessText);
            productAssessment.setOperatorId(userService.queryByUsername(SystemUtils.getCurrentUserName()).getId());
            productAssessment.setAssessTime(Calendar.getInstance().getTime());
            this.productAssessmentService.insertSelective(productAssessment);
            return ResultTool.success();
        } else {
            return ResultTool.fail("产品未通过审核，不可评估");
        }
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

    @ApiOperation(value = "产品模糊搜索和排序")
    @GetMapping("search")
    public JsonResult search(ProductDTO productDTO) {
        PageHelper.startPage(productDTO.getPageNum(), productDTO.getPageSize());
        List<Product> productList = this.productService.search(productDTO);
        return ResultTool.success(PageUtils. getPageResult(new PageInfo<>(productList)));
    }

    @ApiOperation(value = "根据id查询产品，不返回待审核和废弃状态的产品")
    @GetMapping("searchById")
    public JsonResult searchById(Integer id){
        HashMap<String,Object> resultMap = new HashMap<>();
        Product product = productService.queryById(id);
        if (product == null){
            return ResultTool.fail("不存在改产品");
        }
        if (product.getState() < 2 || product.getState() > 4){
            return ResultTool.fail("该产品未审核或已废弃");
        }

        resultMap.put("id",id);
        resultMap.put("name",product.getName());

        return ResultTool.success(resultMap);
    }

    @ApiOperation(value = "根据关键字模糊查询产品，不返回待审核和废弃状态的产品")
    @GetMapping("searchByKeyword")
    public JsonResult searchByKeyword(String keyword){
        List<HashMap<String,Object>> resultList = new ArrayList<>();
        List<Product> products = productService.searchByName(keyword);
        for (Product product : products){
            if (product.getState() >=2 && product.getState() <= 4){
                HashMap<String,Object> resultMap = new HashMap<>();
                resultMap.put("id",product.getId());
                resultMap.put("name",product.getName());
                resultList.add(resultMap);
            }
        }
        return ResultTool.success(resultList);
    }

}
