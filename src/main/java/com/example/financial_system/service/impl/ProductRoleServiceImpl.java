package com.example.financial_system.service.impl;

import com.example.financial_system.entity.ProductRole;
import com.example.financial_system.dao.ProductRoleDao;
import com.example.financial_system.service.ProductRoleService;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (ProductRole)表服务实现类
 *
 * @author laidilin
 * @since 2020-06-07 20:55:38
 */
@Service("productRoleService")
public class ProductRoleServiceImpl implements ProductRoleService {
    @Autowired
    private ProductRoleDao productRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProductRole queryById(Integer id) {
        return this.productRoleDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductRole> queryAllByLimit(int offset, int limit) {
        return this.productRoleDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<ProductRole> queryAll() {
        return this.productRoleDao.queryAll();
    }

    /**
     * 新增数据
     *
     * @param productRole 实例对象
     * @return 实例对象
     */
    @Override
    public ProductRole insert(ProductRole productRole) {
        this.productRoleDao.insert(productRole);
        return productRole;
    }

    /**
     * 修改数据
     *
     * @param productRole 实例对象
     * @return 实例对象
     */
    @Override
    public ProductRole update(ProductRole productRole) {
        this.productRoleDao.update(productRole);
        return this.queryById(productRole.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.productRoleDao.deleteById(id) > 0;
    }
    
    /**
     * 选择性新增数据
     *
     * @param productRole 实例对象
     * @return 实例对象
     */
    @Override
    public ProductRole insertSelective(ProductRole productRole) {
        this.productRoleDao.insert(productRole);
        return productRole;
    }
}