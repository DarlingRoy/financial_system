package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.Operation;
import com.example.financial_system.service.OperationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Operation)表控制层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Api(tags = "(Operation)") 
@RestController
@RequestMapping("operation")
public class OperationController {
    /**
     * 服务对象
     */
    @Autowired
    private OperationService operationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "权限id ID") Integer id) {
        return ResultTool.success(this.operationService.queryById(id));
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param operation 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(Operation operation){
        this.operationService.insertSelective(operation);
        return ResultTool.success();
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param operation 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(Operation operation){
        this.operationService.insert(operation);
        return ResultTool.success();
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param operation 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(Operation operation){
        this.operationService.update(operation);
        return ResultTool.success();
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "权限id ID") Integer id){
        this.operationService.deleteById(id);
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
        return ResultTool.success(this.operationService.queryAll());
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @ApiOperation(value = "返回表中行数")
     @GetMapping("count")
     public JsonResult count() {
        return ResultTool.success(this.operationService.count());
     }

    /**
     * 根据菜单id查询角色id列表
     */
    @ApiOperation(value = "根据菜单id查询角色id列表")
    @GetMapping("selectRoleIdListByOperationId")
    public JsonResult selectRoleIdListByOperationId(@ApiParam(value = "菜单") Integer operationId) {
        Map<String, List<Integer>> roleIdMap = new HashMap<>();
        roleIdMap.put("角色id列表", this.operationService.selectRoleIdListByOperationId(operationId));
        return ResultTool.success(roleIdMap);
    }

}