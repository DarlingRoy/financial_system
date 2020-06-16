package com.example.financial_system.service;

import com.example.financial_system.entity.Department;
import java.util.List;

/**
 * (Department)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
public interface DepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Department queryById(Integer id);
 
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Department> queryAll();

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department update(Department department);

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
     * @param department 实例对象
     * @return 实例对象
     */
    Department insertSelective(Department department);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();
     
}