package com.example.financial_system.service;

import com.example.financial_system.entity.UserProduct;
import java.util.List;

/**
 * (UserProduct)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
public interface UserProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserProduct queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<UserProduct> queryAll();

    /**
     * 新增数据
     *
     * @param userProduct 实例对象
     * @return 实例对象
     */
    UserProduct insert(UserProduct userProduct);

    /**
     * 修改数据
     *
     * @param userProduct 实例对象
     * @return 实例对象
     */
    UserProduct update(UserProduct userProduct);

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
     * @param userProduct 实例对象
     * @return 实例对象
     */
    UserProduct insertSelective(UserProduct userProduct);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();

    /**
     * 根据用户id查询该用户持有产品情况
     * @param userId
     * @return
     */
     List<UserProduct> queryByUserId(Integer userId);

    /**
     * 根据用户id和产品id查询用户持有产品情况
     * @param userId
     * @param productId
     * @return
     */
     UserProduct queryByUserIdAndProductId(Integer userId, Integer productId);

}