package com.example.financial_system.service;

import com.example.financial_system.entity.User;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author laidilin
 * @since 2020-06-07 20:55:39
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<User> queryAll();

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

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
     * @param user 实例对象
     * @return 实例对象
     */
    User insertSelective(User user);

    /**
     * 通过username查询用户id
     *
     * @param username 用户名
     * @return 用户
     */
    User queryByUsername(String username);

}