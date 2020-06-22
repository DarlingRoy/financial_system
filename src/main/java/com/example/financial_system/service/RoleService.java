package com.example.financial_system.service;

import com.example.financial_system.entity.Operation;
import com.example.financial_system.entity.Role;
import java.util.List;

/**
 * (Role)表服务接口
 *
 * @author laidilin
 * @since 2020-06-14 23:40:29
 */
public interface RoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Role> queryAll();

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    Role update(Role role);

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
     * @param role 实例对象
     * @return 实例对象
     */
    Role insertSelective(Role role);

    /**
     * 根据角色id查询用户id列表
     */
    List<Integer> selectUserIdListByRoleId(Integer roleId);

    /**
     * 根据角色id查询部门id
     */
    List<Integer> selectDepartmentIdListByRoleId(Integer roleId);

    /**
     * 根据角色id查询菜单id列表
     */
    List<Integer> selectOperationIdListByRoleId(Integer roleId);



}