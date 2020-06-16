package com.example.financial_system.common.utils;

import com.example.financial_system.common.entity.PageRequest;
import com.example.financial_system.common.entity.PageResult;
import com.github.pagehelper.PageInfo;

/**
 * @Author: linqx
 * @Date: 2020/6/16 10:33
 */
public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
