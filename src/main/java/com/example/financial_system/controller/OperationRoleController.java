package com.example.financial_system.controller;

import com.example.financial_system.entity.OperationRole;
import com.example.financial_system.service.OperationRoleService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (OperationRole)表控制层
 *
 * @author laidilin
 * @since 2020-06-08 10:27:36
 */
@Api(tags = "(OperationRole)") 
@RestController
@RequestMapping("operationRole")
public class OperationRoleController {
    /**
     * 服务对象
     */
    @Autowired
    private OperationRoleService operationRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public OperationRole selectOne(@ApiParam(value = " ID") Integer id) {
        return this.operationRoleService.queryById(id);
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param operationRole 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public void insertSelective(OperationRole operationRole){
        this.operationRoleService.insertSelective(operationRole);
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param operationRole 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public void insert(OperationRole operationRole){
        this.operationRoleService.insert(operationRole);
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param operationRole 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public void update(OperationRole operationRole){
        this.operationRoleService.update(operationRole);
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public void delete(@ApiParam(value = " ID") Integer id){
        this.operationRoleService.deleteById(id);
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
    public List<OperationRole> selectAllByLimit(@ApiParam(value = "查询起始位置") int offset,@ApiParam(value = "查询记录条数") int limit) {
        return this.operationRoleService.queryAllByLimit(offset, limit);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "查询表中所有数据")
    @GetMapping("selectAll")   
    public List<OperationRole> selectAll() {
        return this.operationRoleService.queryAll();
    }

}