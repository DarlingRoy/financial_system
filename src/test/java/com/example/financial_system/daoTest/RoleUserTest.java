package com.example.financial_system.daoTest;

import com.example.financial_system.entity.RoleUser;
import java.util.List;
import com.example.financial_system.dao.RoleUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:26:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleUserTest {

    @Autowired
    private RoleUserDao roleUserDao;
    
    @Test
    public void testQueryAll(){
        List<RoleUser> roleUsers = roleUserDao.queryAll();
        for(RoleUser roleUser : roleUsers){
            System.out.println(roleUser);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<RoleUser> roleUsers = roleUserDao.queryAllByLimit(0,1);
        for(RoleUser roleUser : roleUsers){
            System.out.println(roleUser);
        }
    }
    
    @Test
    public void testQueryById(){
        RoleUser roleUser = roleUserDao.queryById(1);
        System.out.println(roleUser);
    }
    
}