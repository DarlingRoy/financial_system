package com.example.financial_system.dao;

import com.example.financial_system.entity.Role;
import com.example.financial_system.entity.RoleOperation;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Role)表数据库访问层
 *
 * @author laidilin
 * @since 2020-06-14 23:40:29
 */
@Mapper
@Repository 
public interface RoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Role queryById(Integer id);


    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<Role> queryAll();

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int insert(Role role);

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int update(Role role);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    /**
     * 选择性插入数据
     *
     * @param role 实例对象
     * @return 影响行数
     */
    int insertSelective(Role role);

    /**
     * 查询所有角色与权限对应关系
     * @return 角色权限对象
     */
    List<RoleOperation> selectRoleOperation();

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