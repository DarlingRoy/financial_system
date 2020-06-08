package com.example.financial_system.daoTest;

import com.example.financial_system.entity.Operation;
import java.util.List;
import com.example.financial_system.dao.OperationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:21:24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OperationTest {

    @Autowired
    private OperationDao operationDao;
    
    @Test
    public void testQueryAll(){
        List<Operation> operations = operationDao.queryAll();
        for(Operation operation : operations){
            System.out.println(operation);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<Operation> operations = operationDao.queryAllByLimit(0,1);
        for(Operation operation : operations){
            System.out.println(operation);
        }
    }
    
    @Test
    public void testQueryById(){
        Operation operation = operationDao.queryById(1);
        System.out.println(operation);
    }

    @Test
    public void testQueryByUserId(){
        List<Operation> operations = operationDao.queryByUserId(1);
        for (Operation operation:operations){
            System.out.println(operation);
        }
    }
    
}