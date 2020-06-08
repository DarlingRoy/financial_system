package com.example.financial_system.service.impl;

import com.example.financial_system.entity.Repository;
import com.example.financial_system.dao.RepositoryDao;
import com.example.financial_system.service.RepositoryService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Repository)表服务实现类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
@Service("repositoryService")
public class RepositoryServiceImpl implements RepositoryService {
    @Autowired
    private RepositoryDao repositoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Repository queryById(Integer id) {
        return this.repositoryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Repository> queryAllByLimit(int offset, int limit) {
        return this.repositoryDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Repository> queryAll() {
        return this.repositoryDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param repository 实例对象
     * @return 实例对象
     */
    @Override
    public Repository insert(Repository repository) {
        this.repositoryDao.insert(repository);
        return repository;
    }

    /**
     * 修改数据
     *
     * @param repository 实例对象
     * @return 实例对象
     */
    @Override
    public Repository update(Repository repository) {
        this.repositoryDao.update(repository);
        return this.queryById(repository.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.repositoryDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param repository 实例对象
     * @return 实例对象
     */
    @Override
    public Repository insertSelective(Repository repository) {
        this.repositoryDao.insert(repository);
        return repository;
    }
}