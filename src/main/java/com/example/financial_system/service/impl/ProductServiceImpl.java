package com.example.financial_system.service.impl;

import com.example.financial_system.dto.ProductDTO;
import com.example.financial_system.entity.Product;
import com.example.financial_system.dao.ProductDao;
import com.example.financial_system.service.ProductService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
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
}