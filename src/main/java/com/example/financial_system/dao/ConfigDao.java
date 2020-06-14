package com.example.financial_system.dao;

import com.example.financial_system.entity.Config;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * (Config)表数据库访问层
 *
 * @author laidilin
 * @since 2020-06-14 23:40:08
 */
@Mapper
@Repository 
public interface ConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Config queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Config> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<Config> queryAll();

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int insert(Config config);

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 影响行数
     */
    int update(Config config);

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
     * @param config 实例对象
     * @return 影响行数
     */
    int insertSelective(Config config);

}