package com.example.financial_system.service.impl;

import com.example.financial_system.entity.ProductAssessment;
import com.example.financial_system.dao.ProductAssessmentDao;
import com.example.financial_system.service.ProductAssessmentService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 产品评价(ProductAssessment)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 16:27:07
 */
@Service("productAssessmentService")
public class ProductAssessmentServiceImpl implements ProductAssessmentService {
    @Autowired
    private ProductAssessmentDao productAssessmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProductAssessment queryById(Integer id) {
        return this.productAssessmentDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<ProductAssessment> queryAll() {
        return this.productAssessmentDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param productAssessment 实例对象
     * @return 实例对象
     */
    @Override
    public ProductAssessment insert(ProductAssessment productAssessment) {
        this.productAssessmentDao.insert(productAssessment);
        return productAssessment;
    }

    /**
     * 修改数据
     *
     * @param productAssessment 实例对象
     * @return 实例对象
     */
    @Override
    public ProductAssessment update(ProductAssessment productAssessment) {
        this.productAssessmentDao.update(productAssessment);
        return this.queryById(productAssessment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productAssessmentDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param productAssessment 实例对象
     * @return 实例对象
     */
    @Override
    public ProductAssessment insertSelective(ProductAssessment productAssessment) {
        this.productAssessmentDao.insertSelective(productAssessment);
        return productAssessment;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return productAssessmentDao.count();
     }

    /**
     * 根据产品id查询评价
     *
     * @param product_id
     */
    @Override
    public List<ProductAssessment> queryByProductId(Integer product_id) {
        return productAssessmentDao.queryByProductId(product_id);
    }
}