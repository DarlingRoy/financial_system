package com.example.financial_system.service.impl;

import com.example.financial_system.entity.OperationRole;
import com.example.financial_system.dao.OperationRoleDao;
import com.example.financial_system.service.OperationRoleService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (OperationRole)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("operationRoleService")
public class OperationRoleServiceImpl implements OperationRoleService {
    @Autowired
    private OperationRoleDao operationRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public OperationRole queryById(Integer id) {
        return this.operationRoleDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<OperationRole> queryAll() {
        return this.operationRoleDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param operationRole 实例对象
     * @return 实例对象
     */
    @Override
    public OperationRole insert(OperationRole operationRole) {
        this.operationRoleDao.insert(operationRole);
        return operationRole;
    }

    /**
     * 修改数据
     *
     * @param operationRole 实例对象
     * @return 实例对象
     */
    @Override
    public OperationRole update(OperationRole operationRole) {
        this.operationRoleDao.update(operationRole);
        return this.queryById(operationRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.operationRoleDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param operationRole 实例对象
     * @return 实例对象
     */
    @Override
    public OperationRole insertSelective(OperationRole operationRole) {
        this.operationRoleDao.insert(operationRole);
        return operationRole;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return operationRoleDao.count();
     }
}