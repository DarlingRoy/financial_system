package com.example.financial_system.dao;

import com.example.financial_system.entity.Operation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Operation)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Mapper
@Repository 
public interface OperationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Operation queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<Operation> queryAll();

    /**
     * 新增数据
     *
     * @param operation 实例对象
     * @return 影响行数
     */
    int insert(Operation operation);

    /**
     * 修改数据
     *
     * @param operation 实例对象
     * @return 影响行数
     */
    int update(Operation operation);

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
     * @param operation 实例对象
     * @return 影响行数
     */
    int insertSelective(Operation operation);
    
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