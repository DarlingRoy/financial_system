package com.example.financial_system.service.impl;

import com.example.financial_system.entity.RoleUser;
import com.example.financial_system.dao.RoleUserDao;
import com.example.financial_system.service.RoleUserService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 角色-用户(RoleUser)表服务实现类
 *
 * @author linqx
 * @since 2020-06-21 11:26:35
 */
@Service("roleUserService")
public class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    private RoleUserDao roleUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RoleUser queryById(Integer id) {
        return this.roleUserDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<RoleUser> queryAll() {
        return this.roleUserDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param roleUser 实例对象
     * @return 实例对象
     */
    @Override
    public RoleUser insert(RoleUser roleUser) {
        this.roleUserDao.insert(roleUser);
        return roleUser;
    }

    /**
     * 修改数据
     *
     * @param roleUser 实例对象
     * @return 实例对象
     */
    @Override
    public RoleUser update(RoleUser roleUser) {
        this.roleUserDao.update(roleUser);
        return this.queryById(roleUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.roleUserDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param roleUser 实例对象
     * @return 实例对象
     */
    @Override
    public RoleUser insertSelective(RoleUser roleUser) {
        this.roleUserDao.insertSelective(roleUser);
        return roleUser;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return roleUserDao.count();
     }
}