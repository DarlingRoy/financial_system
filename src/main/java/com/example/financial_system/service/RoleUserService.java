package com.example.financial_system.service;

import com.example.financial_system.entity.RoleUser;
import java.util.List;

/**
 * (RoleUser)表服务接口
 *
 * @author laidilin
 * @since 2020-06-07 20:55:39
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
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleUser> queryAllByLimit(int offset, int limit);
    
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

}