package com.example.financial_system.service;

import com.example.financial_system.entity.Operation;
import java.util.List;

/**
 * (Operation)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
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
     * 返回表行数
     *
     * @return 返回表行数
     */
     Integer count();

    /**
     * 根据用户id查询对应权限
     *
     * @param userId 用户表主键
     * @return 权限列表
     */
    List<Operation> queryByUserId(Integer userId);

    /**
     * 根据菜单id返回角色id列表
     */
    List<Integer> selectRoleIdListByOperationId(Integer operationId);

}