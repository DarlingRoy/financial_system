package com.example.financial_system.daoTest;

import com.example.financial_system.entity.User;
import java.util.List;
import com.example.financial_system.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-15 00:25:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserDao userDao;
    
    @Test
    public void testQueryAll(){
        List<User> users = userDao.queryAll();
        for(User user : users){
            System.out.println(user);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<User> users = userDao.queryAllByLimit(0,1);
        for(User user : users){
            System.out.println(user);
        }
    }
    
    @Test
    public void testQueryById(){
        User user = userDao.queryById(1);
        System.out.println(user);
    }
    
}