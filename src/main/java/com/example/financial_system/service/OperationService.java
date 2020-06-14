package com.example.financial_system.service;

import com.example.financial_system.entity.Operation;
import java.util.List;

/**
 * (Operation)表服务接口
 *
 * @author laidilin
 * @since 2020-06-14 23:40:09
 */
public interface OperationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Operation queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Operation> queryAllByLimit(int offset, int limit);
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Operation> queryAll();

    /**
     * 新增数据
     *
     * @param operation 实例对象
     * @return 实例对象
     */
    Operation insert(Operation operation);

    /**
     * 修改数据
     *
     * @param operation 实例对象
     * @return 实例对象
     */
    Operation update(Operation operation);

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
     * @param operation 实例对象
     * @return 实例对象
     */
    Operation insertSelective(Operation operation);

    /**
     * 根据用户id查询对应权限
     *
     * @param userId 用户表主键
     * @return 权限列表
     */
    List<Operation> queryByUserId(Integer userId);

}