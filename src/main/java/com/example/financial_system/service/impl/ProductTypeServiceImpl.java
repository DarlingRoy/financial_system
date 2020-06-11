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
 * @author laidilin
 * @since 2020-06-11 21:30:26
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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductType> queryAllByLimit(int offset, int limit) {
        return this.productTypeDao.queryAllByLimit(offset, limit);
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
        this.productTypeDao.insert(productType);
        return productType;
    }
}