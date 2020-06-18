package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.entity.PageRequest;
import com.example.financial_system.dto.ProviderDTO;
import com.example.financial_system.common.utils.PageUtils;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.Provider;
import com.example.financial_system.service.ProviderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * (Provider)表控制层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Api(tags = "(Provider)")
@RestController
@RequestMapping("provider")
public class ProviderController {
    /**
     * 服务对象
     */
    @Autowired
    private ProviderService providerService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 ")
    @GetMapping("selectOne")
    public JsonResult selectOne(@ApiParam(value = "供应商id ID") Integer id) {
        return ResultTool.success(this.providerService.queryById(id));
    }

    /**
     * 增加一条记录(只填入不为空的字段)
     *
     * @param provider 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(Provider provider) {
        this.providerService.insertSelective(provider);
        return ResultTool.success();
    }

    /**
     * 增加一条记录(填入所有字段)
     *
     * @param provider 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(Provider provider) {
        this.providerService.insert(provider);
        return ResultTool.success();
    }

    /**
     * 更新一条记录(只对不为空的字段进行更新)
     *
     * @param provider 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(Provider provider) {
        this.providerService.update(provider);
        return ResultTool.success();
    }

    /**
     * 根据id删除一条记录
     *
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "供应商id ID") Integer id) {
        this.providerService.deleteById(id);
        return ResultTool.success();
    }

    /**
     * 查询所有供应商
     */
    @GetMapping("selectAll")
    public JsonResult selectAll(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Provider> providerList = providerService.queryAll();
        return ResultTool.success(PageUtils.getPageResult(new PageInfo<>(providerList)));
    }

    /**
     * 查询供应商，提供可选参数
     * @param providerDTO：提供当前页码和每页数量两个参数，提供orderFlag，keyword两个可选参数
     * @return 供应商列表
     */
    @ApiModelProperty("利用可选参数检索供应商")
    @GetMapping("search")
    public JsonResult search(ProviderDTO providerDTO) {
        PageHelper.startPage(providerDTO.getPageNum(), providerDTO.getPageSize());
        List<Provider> providerList = providerService.search(providerDTO);
        return ResultTool.success(PageUtils.getPageResult(new PageInfo<>(providerList)));
    }


    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
    @ApiOperation(value = "返回表中行数")
    @GetMapping("count")
    public JsonResult count() {
        return ResultTool.success(this.providerService.count());
    }

    @ApiOperation(value = "根据供应商名字检索")
    @GetMapping("selectByName")
    public JsonResult selectByName(@ApiParam(value = "供应商名字") String name) {
         return ResultTool.success(this.providerService.queryByName(name));
    }

}