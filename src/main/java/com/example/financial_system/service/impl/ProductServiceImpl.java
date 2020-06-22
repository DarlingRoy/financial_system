package com.example.financial_system.service.impl;

import com.example.financial_system.dao.*;
import com.example.financial_system.dto.ProductDTO;
import com.example.financial_system.entity.Config;
import com.example.financial_system.entity.Product;
import com.example.financial_system.entity.ProductAssessment;
import com.example.financial_system.service.ProductService;
import com.example.financial_system.vo.ProductAssessmentVO;
import com.example.financial_system.vo.ProductVO;
import com.example.financial_system.vo.SubProductVO;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * (Product)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private Mapper mapper;

    @Autowired
    private ProductAssessmentDao productAssessmentDao;

    @Autowired
    private ConfigDao configDao;
    
    @Autowired
    private ProductTypeDao productTypeDao;
    
    @Autowired
    private UserDao userDao;

    @Autowired
    private ProviderDao providerDao;


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Integer id) {
        return this.productDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Product> queryAll() {
        return this.productDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product insert(Product product) {
        this.productDao.insert(product);
        return product;
    }

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product update(Product product) {
        this.productDao.update(product);
        return this.queryById(product.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product insertSelective(Product product) {
        this.productDao.insertSelective(product);
        return product;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return productDao.count();
     }

    /**
     * 实现产品的模糊查询
     *
     * @param productDTO
     * @return
     */
    @Override
    public List<Product> search(ProductDTO productDTO) {
        return productDao.search(productDTO);
    }

    /**
     * 根据产品名称关键字模糊查询
     * @param keyword
     * @return
     */
    @Override
    public List<Product> searchByName(String keyword){
        return productDao.searchByName(keyword);
    }

    /**
     * 获取新品，返回20个上架的“在售”状态的产品
     */
    @Override
    public List<Product> selectNewProduct() {
        return productDao.selectNewProduct();
    }

    /**
     * 将Product转换为ProductVO
     *
     * @param product
     */
    @Override
    public ProductVO convertToVO(Product product) {
        ProductVO productVO = mapper.map(product, ProductVO.class);
        Integer id = product.getId();
        if (productVO.getProductTypeId() != null) {
            productVO.setProviderName(providerDao.queryById(productVO.getProviderId()).getName());
        }
        if (productVO.getProductTypeId() != null) {
            productVO.setProductType(productTypeDao.queryById(productVO.getProductTypeId()).getType());
        }
        if (productVO.getReviewOperatorId() != null) {
            productVO.setReviewOperatorName(userDao.queryById(productVO.getReviewOperatorId()).getUsername());
        }
        if (productAssessmentDao.queryByProductId(id) != null) {
            List<ProductAssessment> productAssessmentList =  productAssessmentDao.queryByProductId(id);
            List<ProductAssessmentVO> productAssessmentVOList = new ArrayList<>();
            for (ProductAssessment productAssessment: productAssessmentList) {
                ProductAssessmentVO productAssessmentVO = mapper.map(productAssessment, ProductAssessmentVO.class);
                if (productDao.queryById(productAssessment.getProductId()) != null) {
                    productAssessmentVO.setProductName(productDao.queryById(productAssessment.getProductId()).getName());
                }
                if (userDao.queryById(productAssessment.getOperatorId()) != null) {
                    productAssessmentVO.setAssessorName(userDao.queryById(productAssessment.getOperatorId()).getUsername());
                }
                productAssessmentVOList.add(productAssessmentVO);
            }
            productVO.setProductAssessments(productAssessmentVOList);
        }
        // 将子产品的id列表转换为子产品的id，名称，收益率
        List<SubProductVO> subProductVOList = new ArrayList<>();
        Config config = configDao.queryById(id);
        if (config != null) {
            String subProductIdList = config.getSubProductList();
            if (subProductIdList != null) {
                String[] strings = subProductIdList.split(",");
                for (String str : strings) {
                    Product subProduct = productDao.queryById(Integer.valueOf(str));
                    SubProductVO subProductVO = new SubProductVO();
                    subProductVO.setProductId(subProduct.getId());
                    subProductVO.setProductName(subProduct.getName());
                    subProductVO.setReturnRate(subProduct.getReturnRate());
                    subProductVOList.add(subProductVO);
                }
            }
        }
        if (product.getProductTypeId() != null) {
            if (product.getProductTypeId() == 1) {
                productVO.setSubProductVOList(subProductVOList);
            }
        }
        return productVO;
    }

    /**
     * 实现“上架”产品的模糊搜索和排序
     *
     * @param productDTO
     */
    @Override
    public List<Product> searchAddedProduct(ProductDTO productDTO) {
        return this.productDao.searchAddedProduct(productDTO);
    }
}