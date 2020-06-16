package com.example.financial_system.service;

import com.example.financial_system.entity.OrderComment;
import java.util.List;

/**
 * (OrderComment)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
public interface OrderCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OrderComment queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<OrderComment> queryAll();

    /**
     * 新增数据
     *
     * @param orderComment 实例对象
     * @return 实例对象
     */
    OrderComment insert(OrderComment orderComment);

    /**
     * 修改数据
     *
     * @param orderComment 实例对象
     * @return 实例对象
     */
    OrderComment update(OrderComment orderComment);

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
     * @param orderComment 实例对象
     * @return 实例对象
     */
    OrderComment insertSelective(OrderComment orderComment);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();
     
}