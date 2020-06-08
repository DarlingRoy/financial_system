package com.example.financial_system.service;

import com.example.financial_system.entity.OperationRole;
import java.util.List;

/**
 * (OperationRole)表服务接口
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
public interface OperationRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    OperationRole queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<OperationRole> queryAllByLimit(int offset, int limit);
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<OperationRole> queryAll();

    /**
     * 新增数据
     *
     * @param operationRole 实例对象
     * @return 实例对象
     */
    OperationRole insert(OperationRole operationRole);

    /**
     * 修改数据
     *
     * @param operationRole 实例对象
     * @return 实例对象
     */
    OperationRole update(OperationRole operationRole);

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
     * @param operationRole 实例对象
     * @return 实例对象
     */
    OperationRole insertSelective(OperationRole operationRole);

}