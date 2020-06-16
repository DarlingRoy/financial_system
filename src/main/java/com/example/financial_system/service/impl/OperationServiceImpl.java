package com.example.financial_system.service.impl;

import com.example.financial_system.entity.Operation;
import com.example.financial_system.dao.OperationDao;
import com.example.financial_system.service.OperationService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Operation)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("operationService")
public class OperationServiceImpl implements OperationService {
    @Autowired
    private OperationDao operationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Operation queryById(Integer id) {
        return this.operationDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Operation> queryAll() {
        return this.operationDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param operation 实例对象
     * @return 实例对象
     */
    @Override
    public Operation insert(Operation operation) {
        this.operationDao.insert(operation);
        return operation;
    }

    /**
     * 修改数据
     *
     * @param operation 实例对象
     * @return 实例对象
     */
    @Override
    public Operation update(Operation operation) {
        this.operationDao.update(operation);
        return this.queryById(operation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.operationDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param operation 实例对象
     * @return 实例对象
     */
    @Override
    public Operation insertSelective(Operation operation) {
        this.operationDao.insert(operation);
        return operation;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return operationDao.count();
     }

    /**
     * 根据用户id查询对应权限
     *
     * @param userId 用户表主键
     * @return 权限列表
     */
    @Override
    public List<Operation> queryByUserId(Integer userId) {
        return this.operationDao.queryByUserId(userId);
    }
}