package com.example.financial_system.service;

import com.example.financial_system.entity.ProductType;
import java.util.List;

/**
 * (ProductType)表服务接口
 *
 * @author laidilin
 * @since 2020-06-11 21:30:26
 */
public interface ProductTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductType queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ProductType> queryAllByLimit(int offset, int limit);
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<ProductType> queryAll();

    /**
     * 新增数据
     *
     * @param productType 实例对象
     * @return 实例对象
     */
    ProductType insert(ProductType productType);

    /**
     * 修改数据
     *
     * @param productType 实例对象
     * @return 实例对象
     */
    ProductType update(ProductType productType);

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
     * @param productType 实例对象
     * @return 实例对象
     */
    ProductType insertSelective(ProductType productType);

}