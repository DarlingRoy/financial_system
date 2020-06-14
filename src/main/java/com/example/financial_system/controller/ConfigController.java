package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.Config;
import com.example.financial_system.service.ConfigService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (Config)表控制层
 *
 * @author laidilin
 * @since 2020-06-14 23:40:08
 */
@Api(tags = "(Config)") 
@RestController
@RequestMapping("config")
public class ConfigController {
    /**
     * 服务对象
     */
    @Autowired
    private ConfigService configService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "产品id ID") Integer id) {
        return ResultTool.success(this.configService.queryById(id));
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param config 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(Config config){
        this.configService.insertSelective(config);
        return ResultTool.success();
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param config 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(Config config){
        this.configService.insert(config);
        return ResultTool.success();
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param config 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PostMapping("update")
    public JsonResult update(Config config){
        this.configService.update(config);
        return ResultTool.success();
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "产品id ID") Integer id){
        this.configService.deleteById(id);
        return ResultTool.success();
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
    public JsonResult selectAllByLimit(@ApiParam(value = "查询起始位置") int offset, @ApiParam(value = "查询记录条数") int limit) {
        return ResultTool.success(this.configService.queryAllByLimit(offset, limit));
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "查询表中所有数据")
    @GetMapping("selectAll")   
    public JsonResult selectAll() {
        return ResultTool.success(this.configService.queryAll());
    }

}