package com.example.financial_system.service;

import com.example.financial_system.entity.RoleDepartment;
import java.util.List;

/**
 * (RoleDepartment)表服务接口
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
public interface RoleDepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleDepartment queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleDepartment> queryAllByLimit(int offset, int limit);
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<RoleDepartment> queryAll();

    /**
     * 新增数据
     *
     * @param roleDepartment 实例对象
     * @return 实例对象
     */
    RoleDepartment insert(RoleDepartment roleDepartment);

    /**
     * 修改数据
     *
     * @param roleDepartment 实例对象
     * @return 实例对象
     */
    RoleDepartment update(RoleDepartment roleDepartment);

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
     * @param roleDepartment 实例对象
     * @return 实例对象
     */
    RoleDepartment insertSelective(RoleDepartment roleDepartment);

}