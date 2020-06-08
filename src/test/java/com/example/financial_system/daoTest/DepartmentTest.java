package com.example.financial_system.daoTest;

import com.example.financial_system.entity.Department;
import java.util.List;
import com.example.financial_system.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:21:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentTest {

    @Autowired
    private DepartmentDao departmentDao;
    
    @Test
    public void testQueryAll(){
        List<Department> departments = departmentDao.queryAll();
        for(Department department : departments){
            System.out.println(department);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<Department> departments = departmentDao.queryAllByLimit(0,1);
        for(Department department : departments){
            System.out.println(department);
        }
    }
    
    @Test
    public void testQueryById(){
        Department department = departmentDao.queryById(1);
        System.out.println(department);
    }
    
}