package com.example.financial_system.daoTest;

import com.example.financial_system.entity.OrderComment;
import java.util.List;
import com.example.financial_system.dao.OrderCommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:22:03
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderCommentTest {

    @Autowired
    private OrderCommentDao orderCommentDao;
    
    @Test
    public void testQueryAll(){
        List<OrderComment> orderComments = orderCommentDao.queryAll();
        for(OrderComment orderComment : orderComments){
            System.out.println(orderComment);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<OrderComment> orderComments = orderCommentDao.queryAllByLimit(0,1);
        for(OrderComment orderComment : orderComments){
            System.out.println(orderComment);
        }
    }
    
    @Test
    public void testQueryById(){
        OrderComment orderComment = orderCommentDao.queryById(1);
        System.out.println(orderComment);
    }
    
}