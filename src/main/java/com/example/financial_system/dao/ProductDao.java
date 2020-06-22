package com.example.financial_system.dao;

import com.example.financial_system.dto.ProductDTO;
import com.example.financial_system.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Product)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Mapper
@Repository
public interface ProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<Product> queryAll();

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int insert(Product product);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int update(Product product);

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
     * @param product 实例对象
     * @return 影响行数
     */
    int insertSelective(Product product);

    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();

    /**
     * 产品模糊搜索、排序
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

    /**
     * 获取新品，返回20个上架的“在售”状态的产品
     */
    List<Product> selectNewProduct();
}