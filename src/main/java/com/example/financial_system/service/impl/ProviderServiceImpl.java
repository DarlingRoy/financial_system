package com.example.financial_system.service.impl;

import com.example.financial_system.entity.Provider;
import com.example.financial_system.dao.ProviderDao;
import com.example.financial_system.service.ProviderService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Provider)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderDao providerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Provider queryById(Integer id) {
        return this.providerDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Provider> queryAll() {
        return this.providerDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param provider 实例对象
     * @return 实例对象
     */
    @Override
    public Provider insert(Provider provider) {
        this.providerDao.insert(provider);
        return provider;
    }

    /**
     * 修改数据
     *
     * @param provider 实例对象
     * @return 实例对象
     */
    @Override
    public Provider update(Provider provider) {
        this.providerDao.update(provider);
        return this.queryById(provider.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.providerDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param provider 实例对象
     * @return 实例对象
     */
    @Override
    public Provider insertSelective(Provider provider) {
        this.providerDao.insert(provider);
        return provider;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return providerDao.count();
     }
}