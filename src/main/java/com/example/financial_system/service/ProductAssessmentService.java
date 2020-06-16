package com.example.financial_system.service;

import com.example.financial_system.entity.ProductAssessment;
import java.util.List;

/**
 * 产品评价(ProductAssessment)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 16:27:07
 */
public interface ProductAssessmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductAssessment queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<ProductAssessment> queryAll();

    /**
     * 新增数据
     *
     * @param productAssessment 实例对象
     * @return 实例对象
     */
    ProductAssessment insert(ProductAssessment productAssessment);

    /**
     * 修改数据
     *
     * @param productAssessment 实例对象
     * @return 实例对象
     */
    ProductAssessment update(ProductAssessment productAssessment);

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
     * @param productAssessment 实例对象
     * @return 实例对象
     */
    ProductAssessment insertSelective(ProductAssessment productAssessment);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();

    /**
     * 根据产品id查询评价
     */
    List<ProductAssessment> queryByProductId(Integer product_id);

}