package com.example.financial_system.service.impl;

import com.example.financial_system.entity.Config;
import com.example.financial_system.dao.ConfigDao;
import com.example.financial_system.service.ConfigService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Config)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("configService")
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigDao configDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Config queryById(Integer id) {
        return this.configDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Config> queryAll() {
        return this.configDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config insert(Config config) {
        this.configDao.insert(config);
        return config;
    }

    /**
     * 修改数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config update(Config config) {
        this.configDao.update(config);
        return this.queryById(config.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.configDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param config 实例对象
     * @return 实例对象
     */
    @Override
    public Config insertSelective(Config config) {
        this.configDao.insertSelective(config);
        return config;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return configDao.count();
     }
}