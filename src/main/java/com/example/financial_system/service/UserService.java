package com.example.financial_system.service;

import com.example.financial_system.entity.User;
import java.util.List;

/**
 * (User)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
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
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();

    /**
     * 通过username查询用户id
     *
     * @param username 用户名
     * @return 用户
     */
    User queryByUsername(String username);

    /**
     * 客户端注册接口
     */
    void clientRegister(User user);

    /**
     * 根据用户id查询角色id列表
     */
    List<Integer> selectRoleIdListByUserId(Integer userId);

}