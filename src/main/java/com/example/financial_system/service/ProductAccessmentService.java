package com.example.financial_system.service;

import com.example.financial_system.entity.ProductAccessment;
import java.util.List;

/**
 * (ProductAccessment)表服务接口
 *
 * @author laidilin
 * @since 2020-06-14 23:40:09
 */
public interface ProductAccessmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductAccessment queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductAccessment> queryAllByLimit(int offset, int limit);
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<ProductAccessment> queryAll();

    /**
     * 新增数据
     *
     * @param productAccessment 实例对象
     * @return 实例对象
     */
    ProductAccessment insert(ProductAccessment productAccessment);

    /**
     * 修改数据
     *
     * @param productAccessment 实例对象
     * @return 实例对象
     */
    ProductAccessment update(ProductAccessment productAccessment);

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
     * @param productAccessment 实例对象
     * @return 实例对象
     */
    ProductAccessment insertSelective(ProductAccessment productAccessment);

}