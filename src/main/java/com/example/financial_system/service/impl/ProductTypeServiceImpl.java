package com.example.financial_system.service.impl;

import com.example.financial_system.entity.ProductType;
import com.example.financial_system.dao.ProductTypeDao;
import com.example.financial_system.service.ProductTypeService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (ProductType)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeDao productTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProductType queryById(Integer id) {
        return this.productTypeDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<ProductType> queryAll() {
        return this.productTypeDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param productType 实例对象
     * @return 实例对象
     */
    @Override
    public ProductType insert(ProductType productType) {
        this.productTypeDao.insert(productType);
        return productType;
    }

    /**
     * 修改数据
     *
     * @param productType 实例对象
     * @return 实例对象
     */
    @Override
    public ProductType update(ProductType productType) {
        this.productTypeDao.update(productType);
        return this.queryById(productType.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productTypeDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param productType 实例对象
     * @return 实例对象
     */
    @Override
    public ProductType insertSelective(ProductType productType) {
        this.productTypeDao.insertSelective(productType);
        return productType;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return productTypeDao.count();
     }
}