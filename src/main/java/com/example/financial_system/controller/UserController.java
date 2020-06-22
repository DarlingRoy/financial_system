package com.example.financial_system.controller;

import com.example.financial_system.common.entity.JsonResult;
import com.example.financial_system.common.entity.PageRequest;
import com.example.financial_system.common.utils.PageUtils;
import com.example.financial_system.common.utils.ResultTool;
import com.example.financial_system.entity.User;
import com.example.financial_system.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author linqx
 * @since 2020-06-16 15:17:23
 */
@Api(tags = "(User)") 
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
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
    public JsonResult selectOne(@ApiParam(value = "用户id ID") Integer id) {
        return ResultTool.success(this.userService.queryById(id));
    }
    
    /**
     * 增加一条记录(只填入不为空的字段)
     * @param user 实例对象
     */
    @ApiOperation("增加一条记录(只填入不为空的字段)")
    @PostMapping("insertSelective")
    public JsonResult insertSelective(User user){
        return ResultTool.success(this.userService.insertSelective(user));
    }
    
    /**
     * 增加一条记录(填入所有字段)
     * @param user 实例对象
     */
    @ApiOperation("增加一条记录(填入所有字段)")
    @PostMapping("insert")
    public JsonResult insert(User user){
        return ResultTool.success(this.userService.insert(user));
    }
    
    /**
     * 更新一条记录(只对不为空的字段进行更新)
     * @param user 实例对象
     */
    @ApiOperation("更新一条记录(只对不为空的字段进行更新)")
    @PutMapping("update")
    public JsonResult update(User user){
        this.userService.update(user);
        return ResultTool.success();
    }
    
    /**
     * 根据id删除一条记录
     * @param id
     */
    @ApiOperation("根据id删除一条记录")
    @DeleteMapping("delete")
    public JsonResult delete(@ApiParam(value = "用户id ID") Integer id){
        this.userService.deleteById(id);
        return ResultTool.success();
    }
    
    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @ApiOperation(value = "查询表中所有数据")
    @GetMapping("selectAll")   
    public JsonResult selectAll(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<User> userList = this.userService.queryAll();
        return ResultTool.success(PageUtils. getPageResult(new PageInfo<>(userList)));
    }
    
    /**
     * 返回表行数
     *
     * @return 返回表行数
     */
     @ApiOperation(value = "返回表中行数")
     @GetMapping("count")
     public JsonResult count() {
        return ResultTool.success(this.userService.count());
     }

    /**
     * 根据用户id查询角色id列表
     */
    @ApiOperation(value = "根据用户id查询角色id列表")
    @GetMapping("selectRoleIdListByUserId")
    public JsonResult selectRoleIdListByUserId(@ApiParam(value = "用户") Integer userId) {
        Map<String, List<Integer>> userIdMap = new HashMap<>();
        userIdMap.put("userIdList", this.userService.selectRoleIdListByUserId(userId));
        return ResultTool.success(userIdMap);
    }

}