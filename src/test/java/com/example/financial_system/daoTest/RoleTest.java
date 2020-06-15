package com.example.financial_system.daoTest;

import com.example.financial_system.entity.Role;
import java.util.List;
import com.example.financial_system.dao.RoleDao;
import com.example.financial_system.entity.RoleOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-15 00:25:35
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RoleTest {

    @Autowired
    private RoleDao roleDao;
    
    @Test
    public void testQueryAll(){
        List<Role> roles = roleDao.queryAll();
        for(Role role : roles){
            System.out.println(role);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<Role> roles = roleDao.queryAllByLimit(0,1);
        for(Role role : roles){
            System.out.println(role);
        }
    }
    
    @Test
    public void testQueryById(){
        Role role = roleDao.queryById(1);
        System.out.println(role);
    }

    @Test
    public void testSelectRoleOperation() {
        List<RoleOperation> list = roleDao.selectRoleOperation();
        for (RoleOperation roleOperation: list) {
            System.out.println(roleOperation);
        }
    }

    
}