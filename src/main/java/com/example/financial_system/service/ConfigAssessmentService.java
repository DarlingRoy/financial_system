package com.example.financial_system.service;

import com.example.financial_system.entity.ConfigAssessment;
import java.util.List;

/**
 * (ConfigAssessment)表服务接口
 *
 * @author laidilin
 * @since 2020-06-14 23:40:08
 */
public interface ConfigAssessmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ConfigAssessment queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ConfigAssessment> queryAllByLimit(int offset, int limit);
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<ConfigAssessment> queryAll();

    /**
     * 新增数据
     *
     * @param configAssessment 实例对象
     * @return 实例对象
     */
    ConfigAssessment insert(ConfigAssessment configAssessment);

    /**
     * 修改数据
     *
     * @param configAssessment 实例对象
     * @return 实例对象
     */
    ConfigAssessment update(ConfigAssessment configAssessment);

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
     * @param configAssessment 实例对象
     * @return 实例对象
     */
    ConfigAssessment insertSelective(ConfigAssessment configAssessment);

}