package com.example.financial_system.service;

import com.example.financial_system.entity.Order;
import java.util.List;

/**
 * (Order)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Order> queryAll();

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

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
     * @param order 实例对象
     * @return 实例对象
     */
    Order insertSelective(Order order);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();
     
}