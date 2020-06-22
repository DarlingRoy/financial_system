package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.Department;
import com.example.financial_system.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Department)表控制层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Api(tags = "(Department)") 
@RestController
@RequestMapping("department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Autowired
    private DepartmentService departmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "部门id ID") Integer id) {
        return ResultTool.success(this.departmentService.queryById(id));
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param department 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(Department department){
        return ResultTool.success(this.departmentService.insertSelective(department));
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param department 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(Department department){
        return ResultTool.success(this.departmentService.insert(department));
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param department 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(Department department){
        this.departmentService.update(department);
        return ResultTool.success();
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "部门id ID") Integer id){
        this.departmentService.deleteById(id);
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
        return ResultTool.success(this.departmentService.queryAll());
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @ApiOperation(value = "返回表中行数")
     @GetMapping("count")
     public JsonResult count() {
        return ResultTool.success(this.departmentService.count());
     }


    /**
     * 根据部门id查询角色id列表
     */
    @ApiOperation(value = "根据部门id查询角色id列表")
    @GetMapping("selectRoleIdListByDepartmentId")
    public JsonResult selectRoleIdListByDepartmentId(@ApiParam(value = "部门id") Integer departmentId) {
        Map<String, List<Integer>> roleIdMap = new HashMap<>();
        roleIdMap.put("roleIdList", this.departmentService.selectRoleIdListByDepartmentId(departmentId));
        return ResultTool.success(roleIdMap);
    }
}