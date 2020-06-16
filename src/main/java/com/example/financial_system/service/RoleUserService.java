package com.example.financial_system.service;

import com.example.financial_system.entity.RoleUser;
import java.util.List;

/**
 * (RoleUser)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
public interface RoleUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleUser queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<RoleUser> queryAll();

    /**
     * 新增数据
     *
     * @param roleUser 实例对象
     * @return 实例对象
     */
    RoleUser insert(RoleUser roleUser);

    /**
     * 修改数据
     *
     * @param roleUser 实例对象
     * @return 实例对象
     */
    RoleUser update(RoleUser roleUser);

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
     * @param roleUser 实例对象
     * @return 实例对象
     */
    RoleUser insertSelective(RoleUser roleUser);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();
     
}