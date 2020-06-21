package com.example.financial_system.service.impl;

import com.example.financial_system.entity.Department;
import com.example.financial_system.dao.DepartmentDao;
import com.example.financial_system.service.DepartmentService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Department queryById(Integer id) {
        return this.departmentDao.queryById(id);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Department> queryAll() {
        return this.departmentDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        this.departmentDao.insert(department);
        return department;
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        this.departmentDao.update(department);
        return this.queryById(department.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.departmentDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insertSelective(Department department) {
        this.departmentDao.insertSelective(department);
        return department;
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @Override
     public Integer count(){
        return departmentDao.count();
     }

    /**
     * 根据部门id查询角色id列表
     *
     * @param departmentId
     */
    @Override
    public List<Integer> selectRoleIdListByDepartmentId(Integer departmentId) {
        return departmentDao.selectRoleIdListByDepartmentId(departmentId);
    }
}