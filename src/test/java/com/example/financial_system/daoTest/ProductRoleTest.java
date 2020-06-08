package com.example.financial_system.daoTest;

import com.example.financial_system.entity.ProductRole;
import java.util.List;
import com.example.financial_system.dao.ProductRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:23:12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductRoleTest {

    @Autowired
    private ProductRoleDao productRoleDao;
    
    @Test
    public void testQueryAll(){
        List<ProductRole> productRoles = productRoleDao.queryAll();
        for(ProductRole productRole : productRoles){
            System.out.println(productRole);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<ProductRole> productRoles = productRoleDao.queryAllByLimit(0,1);
        for(ProductRole productRole : productRoles){
            System.out.println(productRole);
        }
    }
    
    @Test
    public void testQueryById(){
        ProductRole productRole = productRoleDao.queryById(1);
        System.out.println(productRole);
    }
    
}