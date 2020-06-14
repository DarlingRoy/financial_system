package com.example.financial_system.service.impl;

import com.example.financial_system.entity.ConfigAssessment;
import com.example.financial_system.dao.ConfigAssessmentDao;
import com.example.financial_system.service.ConfigAssessmentService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (ConfigAssessment)表服务实现类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:08
 */
@Service("configAssessmentService")
public class ConfigAssessmentServiceImpl implements ConfigAssessmentService {
    @Autowired
    private ConfigAssessmentDao configAssessmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ConfigAssessment queryById(Integer id) {
        return this.configAssessmentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ConfigAssessment> queryAllByLimit(int offset, int limit) {
        return this.configAssessmentDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<ConfigAssessment> queryAll() {
        return this.configAssessmentDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param configAssessment 实例对象
     * @return 实例对象
     */
    @Override
    public ConfigAssessment insert(ConfigAssessment configAssessment) {
        this.configAssessmentDao.insert(configAssessment);
        return configAssessment;
    }

    /**
     * 修改数据
     *
     * @param configAssessment 实例对象
     * @return 实例对象
     */
    @Override
    public ConfigAssessment update(ConfigAssessment configAssessment) {
        this.configAssessmentDao.update(configAssessment);
        return this.queryById(configAssessment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.configAssessmentDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param configAssessment 实例对象
     * @return 实例对象
     */
    @Override
    public ConfigAssessment insertSelective(ConfigAssessment configAssessment) {
        this.configAssessmentDao.insert(configAssessment);
        return configAssessment;
    }
}