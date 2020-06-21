package com.example.financial_system.service;

import com.example.financial_system.entity.OperationRole;
import java.util.List;

/**
 * 权限-角色(OperationRole)表服务接口
 *
 * @author linqx
 * @since 2020-06-21 11:26:35
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
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();
     
}