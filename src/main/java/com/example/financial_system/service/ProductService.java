package com.example.financial_system.service;

import com.example.financial_system.dto.ProductDTO;
import com.example.financial_system.entity.Product;

import java.util.List;

/**
 * (Product)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
public interface ProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Product> queryAll();

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product insert(Product product);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product update(Product product);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    /**
     * 选择性插入数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product insertSelective(Product product);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();

    /**
     * 实现产品的模糊查询
     * @param productDTO
     * @return
     */
     List<Product> search(ProductDTO productDTO);

    /**
     * 根据产品名称关键字模糊查询
     * @param keyword
     * @return
     */
    List<Product> searchByName(String keyword);
     
}