package com.example.financial_system.service.impl;

import com.example.financial_system.entity.ProductAccessment;
import com.example.financial_system.dao.ProductAccessmentDao;
import com.example.financial_system.service.ProductAccessmentService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (ProductAccessment)表服务实现类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:09
 */
@Service("productAccessmentService")
public class ProductAccessmentServiceImpl implements ProductAccessmentService {
    @Autowired
    private ProductAccessmentDao productAccessmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProductAccessment queryById(Integer id) {
        return this.productAccessmentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductAccessment> queryAllByLimit(int offset, int limit) {
        return this.productAccessmentDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<ProductAccessment> queryAll() {
        return this.productAccessmentDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param productAccessment 实例对象
     * @return 实例对象
     */
    @Override
    public ProductAccessment insert(ProductAccessment productAccessment) {
        this.productAccessmentDao.insert(productAccessment);
        return productAccessment;
    }

    /**
     * 修改数据
     *
     * @param productAccessment 实例对象
     * @return 实例对象
     */
    @Override
    public ProductAccessment update(ProductAccessment productAccessment) {
        this.productAccessmentDao.update(productAccessment);
        return this.queryById(productAccessment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productAccessmentDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param productAccessment 实例对象
     * @return 实例对象
     */
    @Override
    public ProductAccessment insertSelective(ProductAccessment productAccessment) {
        this.productAccessmentDao.insert(productAccessment);
        return productAccessment;
    }
}