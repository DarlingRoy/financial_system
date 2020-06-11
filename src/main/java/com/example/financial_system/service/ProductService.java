package com.example.financial_system.service;

import com.example.financial_system.entity.Product;
import java.util.List;

/**
 * (Product)表服务接口
 *
 * @author laidilin
 * @since 2020-06-11 21:29:53
 */
public interface ProductService {

    /**
     * 根据产品id，查询产品所有信息、产品对应供应商的id和名称、以及产品对应的类型
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Product> queryAllByLimit(int offset, int limit);
    
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


}