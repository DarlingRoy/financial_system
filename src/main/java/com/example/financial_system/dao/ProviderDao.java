package com.example.financial_system.dao;

import com.example.financial_system.dto.ProviderDTO;
import com.example.financial_system.entity.Provider;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (Provider)表数据库访问层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Mapper
@Repository 
public interface ProviderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Provider queryById(Integer id);

    /**
     * 查找所有记录
     *
     * @return 对象列表
     */
    List<Provider> queryAll();

    /**
     * 新增数据
     *
     * @param provider 实例对象
     * @return 影响行数
     */
    int insert(Provider provider);

    /**
     * 修改数据
     *
     * @param provider 实例对象
     * @return 影响行数
     */
    int update(Provider provider);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    /**
     * 选择性插入数据
     *
     * @param provider 实例对象
     * @return 影响行数
     */
    int insertSelective(Provider provider);
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    Integer count();

    /**
     * 根据名字搜索供应商
     * @param name 供应商名字
     * @return 供应商
     */
    Provider queryByName(String name);

    /**
     * 供应商模糊搜索、排序
     */
    List<Provider> search(ProviderDTO providerDTO);
}