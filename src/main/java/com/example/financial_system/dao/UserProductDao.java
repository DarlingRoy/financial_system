package com.example.financial_system.dao;

import com.example.financial_system.entity.UserProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (UserProduct)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Mapper
@Repository 
public interface UserProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserProduct queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<UserProduct> queryAll();

    /**
     * 新增数据
     *
     * @param userProduct 实例对象
     * @return 影响行数
     */
    int insert(UserProduct userProduct);

    /**
     * 修改数据
     *
     * @param userProduct 实例对象
     * @return 影响行数
     */
    int update(UserProduct userProduct);

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
     * @param userProduct 实例对象
     * @return 影响行数
     */
    int insertSelective(UserProduct userProduct);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();

    /**
     * 根据用户id查询用户持有产品情况
     * @param userId
     * @return
     */
    List<UserProduct> queryByUserId(Integer userId);

    /**
     * 根据用户id和产品id查询用户持有产品信息
     * @param userId
     * @param productId
     * @return
     */
    UserProduct queryByUserIdAndProductId(Integer userId, Integer productId);
}