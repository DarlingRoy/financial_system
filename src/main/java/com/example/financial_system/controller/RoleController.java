package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.Role;
import com.example.financial_system.service.RoleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Role)表控制层
 *
 * @author laidilin
 * @since 2020-06-14 23:40:29
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
    public JsonResult selectOne(@ApiParam(value = " ID") Integer id) {
        return ResultTool.success(this.roleService.queryById(id));
    }

    /**
     * 增加一条记录(只填入不为空的字段)
     *
     * @param role 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(Role role) {
        this.roleService.insertSelective(role);
        return ResultTool.success();
    }

    /**
     * 增加一条记录(填入所有字段)
     *
     * @param role 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(Role role) {
        this.roleService.insert(role);
        return ResultTool.success();
    }

    /**
     * 更新一条记录(只对不为空的字段进行更新)
     *
     * @param role 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PostMapping("update")
    public JsonResult update(Role role) {
        this.roleService.update(role);
        return ResultTool.success();
    }

    /**
     * 根据id删除一条记录
     *
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = " ID") Integer id) {
        this.roleService.deleteById(id);
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
        return ResultTool.success(this.roleService.queryAll());
    }

    /**
     * 根据角色id查询用户id列表
     */
    @ApiOperation(value = "根据角色id查询用户id列表")
    @GetMapping("selectUserIdListByRoleId")
    public JsonResult selectUserIdListByRoleId(@ApiParam(value = "角色id") Integer roleId) {
        Map<String, List<Integer>> userIdMap = new HashMap<>();
        userIdMap.put("userIdList", this.roleService.selectUserIdListByRoleId(roleId));
        return ResultTool.success(userIdMap);
    }

    /**
     * 根据角色id查询部门id
     */
    @ApiOperation(value = "根据角色id查询部门id列表")
    @GetMapping("selectDepartmentIdListByRoleId")
    public JsonResult selectDepartmentIdListByRoleId(@ApiParam(value = "角色id") Integer roleId) {
        Map<String, List<Integer>> departmentIdMap = new HashMap<>();
        departmentIdMap.put("departmentIdList", this.roleService.selectDepartmentIdListByRoleId(roleId));
        return ResultTool.success(departmentIdMap);
    }

    /**
     * 根据角色id查询菜单id列表
     */
    @ApiOperation(value = "根据角色id查询菜单id列表")
    @GetMapping("selectOperationIdListByRoleId")
    public JsonResult selectOperationIdListByRoleId(@ApiParam(value = "角色id") Integer roleId) {
        Map<String, List<Integer>> operationIdMap = new HashMap<>();
        operationIdMap.put("operationIdList", this.roleService.selectOperationIdListByRoleId(roleId));
        return ResultTool.success(operationIdMap);
    }

}