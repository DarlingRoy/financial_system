package com.example.financial_system.dao;

import com.example.financial_system.entity.ProductAssessment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 产品评价(ProductAssessment)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-16 16:27:07
 */
@Mapper
@Repository 
public interface ProductAssessmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductAssessment queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<ProductAssessment> queryAll();

    /**
     * 新增数据
     *
     * @param productAssessment 实例对象
     * @return 影响行数
     */
    int insert(ProductAssessment productAssessment);

    /**
     * 修改数据
     *
     * @param productAssessment 实例对象
     * @return 影响行数
     */
    int update(ProductAssessment productAssessment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    /**
     * 选择性插入数据
     *
     * @param productAssessment 实例对象
     * @return 影响行数
     */
    int insertSelective(ProductAssessment productAssessment);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();

    List<ProductAssessment> queryByProductId(Integer product_id);
}