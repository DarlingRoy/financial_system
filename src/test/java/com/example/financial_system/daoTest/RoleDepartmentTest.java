package com.example.financial_system.daoTest;

import com.example.financial_system.entity.RoleDepartment;
import java.util.List;
import com.example.financial_system.dao.RoleDepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:26:41
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleDepartmentTest {

    @Autowired
    private RoleDepartmentDao roleDepartmentDao;
    
    @Test
    public void testQueryAll(){
        List<RoleDepartment> roleDepartments = roleDepartmentDao.queryAll();
        for(RoleDepartment roleDepartment : roleDepartments){
            System.out.println(roleDepartment);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<RoleDepartment> roleDepartments = roleDepartmentDao.queryAllByLimit(0,1);
        for(RoleDepartment roleDepartment : roleDepartments){
            System.out.println(roleDepartment);
        }
    }
    
    @Test
    public void testQueryById(){
        RoleDepartment roleDepartment = roleDepartmentDao.queryById(1);
        System.out.println(roleDepartment);
    }
    
}