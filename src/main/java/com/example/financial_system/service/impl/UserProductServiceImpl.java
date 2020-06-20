package com.example.financial_system.service.impl;

import com.example.financial_system.entity.UserProduct;
import com.example.financial_system.dao.UserProductDao;
import com.example.financial_system.service.UserProductService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (UserProduct)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("userProductService")
public class UserProductServiceImpl implements UserProductService {
    @Autowired
    private UserProductDao userProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserProduct queryById(Integer id) {
        return this.userProductDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<UserProduct> queryAll() {
        return this.userProductDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param userProduct 实例对象
     * @return 实例对象
     */
    @Override
    public UserProduct insert(UserProduct userProduct) {
        this.userProductDao.insert(userProduct);
        return userProduct;
    }

    /**
     * 修改数据
     *
     * @param userProduct 实例对象
     * @return 实例对象
     */
    @Override
    public UserProduct update(UserProduct userProduct) {
        this.userProductDao.update(userProduct);
        return this.queryById(userProduct.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userProductDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param userProduct 实例对象
     * @return 实例对象
     */
    @Override
    public UserProduct insertSelective(UserProduct userProduct) {
        this.userProductDao.insertSelective(userProduct);
        return userProduct;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return userProductDao.count();
     }

    /**
     * 根据用户id查询该用户持有产品情况
     *
     * @param userId
     * @return
     */
    @Override
    public List<UserProduct> queryByUserId(Integer userId) {
        return userProductDao.queryByUserId(userId);
    }

    /**
     * 根据用户id和产品id查询用户持有产品情况
     *
     * @param userId
     * @param productId
     * @return
     */
    @Override
    public UserProduct queryByUserIdAndProductId(Integer userId, Integer productId) {
        return userProductDao.queryByUserIdAndProductId(userId, productId);
    }
}