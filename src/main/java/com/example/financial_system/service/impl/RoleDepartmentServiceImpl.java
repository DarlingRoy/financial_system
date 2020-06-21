package com.example.financial_system.service.impl;

import com.example.financial_system.entity.RoleDepartment;
import com.example.financial_system.dao.RoleDepartmentDao;
import com.example.financial_system.service.RoleDepartmentService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 角色-部门(RoleDepartment)表服务实现类
 *
 * @author linqx
 * @since 2020-06-21 11:26:35
 */
@Service("roleDepartmentService")
public class RoleDepartmentServiceImpl implements RoleDepartmentService {
    @Autowired
    private RoleDepartmentDao roleDepartmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleDepartment queryById(Integer id) {
        return this.roleDepartmentDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<RoleDepartment> queryAll() {
        return this.roleDepartmentDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param roleDepartment 实例对象
     * @return 实例对象
     */
    @Override
    public RoleDepartment insert(RoleDepartment roleDepartment) {
        this.roleDepartmentDao.insert(roleDepartment);
        return roleDepartment;
    }

    /**
     * 修改数据
     *
     * @param roleDepartment 实例对象
     * @return 实例对象
     */
    @Override
    public RoleDepartment update(RoleDepartment roleDepartment) {
        this.roleDepartmentDao.update(roleDepartment);
        return this.queryById(roleDepartment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleDepartmentDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param roleDepartment 实例对象
     * @return 实例对象
     */
    @Override
    public RoleDepartment insertSelective(RoleDepartment roleDepartment) {
        this.roleDepartmentDao.insertSelective(roleDepartment);
        return roleDepartment;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return roleDepartmentDao.count();
     }
}