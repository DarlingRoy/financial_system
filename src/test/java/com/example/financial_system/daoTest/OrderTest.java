package com.example.financial_system.daoTest;

import com.example.financial_system.entity.Order;
import java.util.List;
import com.example.financial_system.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:21:51
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderTest {

    @Autowired
    private OrderDao orderDao;
    
    @Test
    public void testQueryAll(){
        List<Order> orders = orderDao.queryAll();
        for(Order order : orders){
            System.out.println(order);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<Order> orders = orderDao.queryAllByLimit(0,1);
        for(Order order : orders){
            System.out.println(order);
        }
    }
    
    @Test
    public void testQueryById(){
        Order order = orderDao.queryById(1);
        System.out.println(order);
    }
    
}