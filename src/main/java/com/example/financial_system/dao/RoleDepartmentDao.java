package com.example.financial_system.dao;

import com.example.financial_system.entity.RoleDepartment;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (RoleDepartment)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Mapper
@Repository 
public interface RoleDepartmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleDepartment queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<RoleDepartment> queryAll();

    /**
     * 新增数据
     *
     * @param roleDepartment 实例对象
     * @return 影响行数
     */
    int insert(RoleDepartment roleDepartment);

    /**
     * 修改数据
     *
     * @param roleDepartment 实例对象
     * @return 影响行数
     */
    int update(RoleDepartment roleDepartment);

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
     * @param roleDepartment 实例对象
     * @return 影响行数
     */
    int insertSelective(RoleDepartment roleDepartment);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();
}