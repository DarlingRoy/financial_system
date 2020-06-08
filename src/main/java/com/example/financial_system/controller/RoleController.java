package com.example.financial_system.controller;

import com.example.financial_system.entity.Role;
import com.example.financial_system.service.RoleService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author laidilin
 * @since 2020-06-08 10:29:11
 */
@Api(tags = "(Role)") 
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Autowired
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public Role selectOne(@ApiParam(value = " ID") Integer id) {
        return this.roleService.queryById(id);
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param role 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public void insertSelective(Role role){
        this.roleService.insertSelective(role);
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param role 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public void insert(Role role){
        this.roleService.insert(role);
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param role 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public void update(Role role){
        this.roleService.update(role);
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public void delete(@ApiParam(value = " ID") Integer id){
        this.roleService.deleteById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @ApiOperation(value = "根据起始位置和查询条数查询多条数据")
    @GetMapping("selectAllByLimit")   
    public List<Role> selectAllByLimit(@ApiParam(value = "查询起始位置") int offset,@ApiParam(value = "查询记录条数") int limit) {
        return this.roleService.queryAllByLimit(offset, limit);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "根据表中所有数据")
    @GetMapping("selectAll")   
    public List<Role> selectAll() {
        return this.roleService.queryAll();
    }

}