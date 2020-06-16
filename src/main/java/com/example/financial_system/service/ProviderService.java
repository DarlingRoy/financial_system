package com.example.financial_system.service;

import com.example.financial_system.entity.Provider;

import java.util.List;

/**
 * (Provider)表服务接口
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
public interface ProviderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Provider queryById(Integer id);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Provider> queryAll();

    /**
     * 新增数据
     *
     * @param provider 实例对象
     * @return 实例对象
     */
    Provider insert(Provider provider);

    /**
     * 修改数据
     *
     * @param provider 实例对象
     * @return 实例对象
     */
    Provider update(Provider provider);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 选择性插入数据
     *
     * @param provider 实例对象
     * @return 实例对象
     */
    Provider insertSelective(Provider provider);

    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();

    /**
     * 根据供应商名字检索
     * @param name
     * @return 供应商
     */
     Provider queryByName(String name);
}