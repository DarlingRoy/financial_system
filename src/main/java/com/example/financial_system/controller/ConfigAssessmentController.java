package com.example.financial_system.controller;

import com.example.financial_system.entity.ConfigAssessment;
import com.example.financial_system.service.ConfigAssessmentService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * (ConfigAssessment)表控制层
 *
 * @author laidilin
 * @since 2020-06-08 10:27:04
 */
@Api(tags = "(ConfigAssessment)") 
@RestController
@RequestMapping("configAssessment")
public class ConfigAssessmentController {
    /**
     * 服务对象
     */
    @Autowired
    private ConfigAssessmentService configAssessmentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public ConfigAssessment selectOne(@ApiParam(value = " ID") Integer id) {
        return this.configAssessmentService.queryById(id);
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param configAssessment 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public void insertSelective(ConfigAssessment configAssessment){
        this.configAssessmentService.insertSelective(configAssessment);
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param configAssessment 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public void insert(ConfigAssessment configAssessment){
        this.configAssessmentService.insert(configAssessment);
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param configAssessment 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public void update(ConfigAssessment configAssessment){
        this.configAssessmentService.update(configAssessment);
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public void delete(@ApiParam(value = " ID") Integer id){
        this.configAssessmentService.deleteById(id);
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
    public List<ConfigAssessment> selectAllByLimit(@ApiParam(value = "查询起始位置") int offset,@ApiParam(value = "查询记录条数") int limit) {
        return this.configAssessmentService.queryAllByLimit(offset, limit);
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "查询表中所有数据")
    @GetMapping("selectAll")   
    public List<ConfigAssessment> selectAll() {
        return this.configAssessmentService.queryAll();
    }

}