package com.example.financial_system.service.impl;

import com.example.financial_system.entity.Role;
import com.example.financial_system.dao.RoleDao;
import com.example.financial_system.service.RoleService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Role)表服务实现类
 *
 * @author laidilin
 * @since 2020-06-14 23:40:29
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Role queryById(Integer id) {
        return this.roleDao.queryById(id);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Role> queryAll() {
        return this.roleDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insert(Role role) {
        this.roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role update(Role role) {
        this.roleDao.update(role);
        return this.queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param role 实例对象
     * @return 实例对象
     */
    @Override
    public Role insertSelective(Role role) {
        this.roleDao.insert(role);
        return role;
    }
}