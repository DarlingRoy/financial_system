package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.RoleUser;
import com.example.financial_system.service.RoleUserService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * 角色-用户(RoleUser)表控制层
 *
 * @author linqx
 * @since 2020-06-21 11:26:35
 */
@Api(tags = "角色-用户(RoleUser)") 
@RestController
@RequestMapping("roleUser")
public class RoleUserController {
    /**
     * 服务对象
     */
    @Autowired
    private RoleUserService roleUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 角色-用户")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "角色-用户id ID") Integer id) {
        return ResultTool.success(this.roleUserService.queryById(id));
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param roleUser 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(RoleUser roleUser){
        this.roleUserService.insertSelective(roleUser);
        return ResultTool.success();
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param roleUser 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(RoleUser roleUser){
        this.roleUserService.insert(roleUser);
        return ResultTool.success();
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param roleUser 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(RoleUser roleUser){
        this.roleUserService.update(roleUser);
        return ResultTool.success();
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "角色-用户id ID") Integer id){
        this.roleUserService.deleteById(id);
        return ResultTool.success();
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "查询表中所有数据")
    @GetMapping("selectAll")   
    public JsonResult selectAll() {
        return ResultTool.success(this.roleUserService.queryAll());
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @ApiOperation(value = "返回表中行数")
     @GetMapping("count")
     public JsonResult count() {
        return ResultTool.success(this.roleUserService.count());
     }

}