package com.example.financial_system.service.impl;

import com.example.financial_system.entity.OrderComment;
import com.example.financial_system.dao.OrderCommentDao;
import com.example.financial_system.service.OrderCommentService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (OrderComment)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("orderCommentService")
public class OrderCommentServiceImpl implements OrderCommentService {
    @Autowired
    private OrderCommentDao orderCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OrderComment queryById(Integer id) {
        return this.orderCommentDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<OrderComment> queryAll() {
        return this.orderCommentDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param orderComment 实例对象
     * @return 实例对象
     */
    @Override
    public OrderComment insert(OrderComment orderComment) {
        this.orderCommentDao.insert(orderComment);
        return orderComment;
    }

    /**
     * 修改数据
     *
     * @param orderComment 实例对象
     * @return 实例对象
     */
    @Override
    public OrderComment update(OrderComment orderComment) {
        this.orderCommentDao.update(orderComment);
        return this.queryById(orderComment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderCommentDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param orderComment 实例对象
     * @return 实例对象
     */
    @Override
    public OrderComment insertSelective(OrderComment orderComment) {
        this.orderCommentDao.insert(orderComment);
        return orderComment;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return orderCommentDao.count();
     }
}