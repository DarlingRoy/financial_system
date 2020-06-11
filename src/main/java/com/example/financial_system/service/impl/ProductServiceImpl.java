package com.example.financial_system.service.impl;

import com.example.financial_system.entity.Product;
import com.example.financial_system.dao.ProductDao;
import com.example.financial_system.service.ProductService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Product)表服务实现类
 *
 * @author laidilin
 * @since 2020-06-11 21:29:53
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    /**
     * 根据产品id，查询产品所有信息、产品对应供应商的id和名称、以及产品对应的类型
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Integer id) {
        return this.productDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Product> queryAllByLimit(int offset, int limit) {
        return this.productDao.queryAllByLimit(offset, limit);
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
        this.productDao.insert(product);
        return product;
    }


}