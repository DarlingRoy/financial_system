package com.example.financial_system.service.impl;

import com.example.financial_system.entity.User;
import com.example.financial_system.dao.UserDao;
import com.example.financial_system.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<User> queryAll() {
        return this.userDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insertSelective(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.userDao.insertSelective(user);
        Integer id = this.userDao.queryByUsername(user.getUsername()).getId();
        this.userDao.insertUserGeneralRole(id);
        return user;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return userDao.count();
     }

    /**
     * 通过username查询用户id
     *
     * @param username 用户名
     * @return 用户
     */
    @Override
    public User queryByUsername(String username) {
        return this.userDao.queryByUsername(username);
    }

    /**
     * 客户端注册接口
     *
     * @param user 注册的用户
     */
    @Override
    public void clientRegister(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.userDao.insertSelective(user);
        Integer id = this.userDao.queryByUsername(user.getUsername()).getId();
        this.userDao.insertUserGeneralRole(id);
    }

    /**
     * 根据用户id查询角色id列表
     *
     * @param userId
     */
    @Override
    public List<Integer> selectRoleIdListByUserId(Integer userId) {
        return this.userDao.selectRoleIdListByUserId(userId);
    }
}