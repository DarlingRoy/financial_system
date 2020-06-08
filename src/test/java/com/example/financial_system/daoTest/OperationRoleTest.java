package com.example.financial_system.daoTest;

import com.example.financial_system.entity.OperationRole;
import java.util.List;
import com.example.financial_system.dao.OperationRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:21:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OperationRoleTest {

    @Autowired
    private OperationRoleDao operationRoleDao;
    
    @Test
    public void testQueryAll(){
        List<OperationRole> operationRoles = operationRoleDao.queryAll();
        for(OperationRole operationRole : operationRoles){
            System.out.println(operationRole);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<OperationRole> operationRoles = operationRoleDao.queryAllByLimit(0,1);
        for(OperationRole operationRole : operationRoles){
            System.out.println(operationRole);
        }
    }
    
    @Test
    public void testQueryById(){
        OperationRole operationRole = operationRoleDao.queryById(1);
        System.out.println(operationRole);
    }
    
}