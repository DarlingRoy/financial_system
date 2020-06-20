package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.ConfigAssessment;
import com.example.financial_system.service.ConfigAssessmentService;
import com.example.financial_system.service.UserService;
import com.example.financial_system.vo.ConfigAssessmentVO;
import com.example.financial_system.vo.ProductVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * (ConfigAssessment)表控制层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
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

    @Autowired
    private Mapper mapper;

    @Autowired
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "配置评价id ID") Integer id) {
        ConfigAssessment configAssessment = this.configAssessmentService.queryById(id);
        String operatorName = userService.queryById(configAssessment.getOperatorId()).getUsername();
        ConfigAssessmentVO configAssessmentVO = mapper.map(configAssessment, ConfigAssessmentVO.class);
        configAssessmentVO.setOperatorName(operatorName);
        return ResultTool.success(configAssessmentVO);
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param configAssessment 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(ConfigAssessment configAssessment){
        this.configAssessmentService.insertSelective(configAssessment);
        return ResultTool.success();
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param configAssessment 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(ConfigAssessment configAssessment){
        this.configAssessmentService.insert(configAssessment);
        return ResultTool.success();
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param configAssessment 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(ConfigAssessment configAssessment){
        this.configAssessmentService.update(configAssessment);
        return ResultTool.success();
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "配置评价id ID") Integer id){
        this.configAssessmentService.deleteById(id);
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
        List<ConfigAssessment> configAssessmentList = this.configAssessmentService.queryAll();
        List<ConfigAssessmentVO> configAssessmentVOList = new ArrayList<>();
        for (ConfigAssessment configAssessment: configAssessmentList) {
            String operatorName = userService.queryById(configAssessment.getOperatorId()).getUsername();
            ConfigAssessmentVO configAssessmentVO = mapper.map(configAssessment, ConfigAssessmentVO.class);
            configAssessmentVO.setOperatorName(operatorName);
            configAssessmentVOList.add(configAssessmentVO);
        }
        return ResultTool.success(configAssessmentVOList);
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @ApiOperation(value = "返回表中行数")
     @GetMapping("count")
     public JsonResult count() {
        return ResultTool.success(this.configAssessmentService.count());
     }

}