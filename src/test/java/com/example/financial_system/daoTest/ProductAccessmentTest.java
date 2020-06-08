package com.example.financial_system.daoTest;

import com.example.financial_system.entity.ProductAccessment;
import java.util.List;
import com.example.financial_system.dao.ProductAccessmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:22:49
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductAccessmentTest {

    @Autowired
    private ProductAccessmentDao productAccessmentDao;
    
    @Test
    public void testQueryAll(){
        List<ProductAccessment> productAccessments = productAccessmentDao.queryAll();
        for(ProductAccessment productAccessment : productAccessments){
            System.out.println(productAccessment);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<ProductAccessment> productAccessments = productAccessmentDao.queryAllByLimit(0,1);
        for(ProductAccessment productAccessment : productAccessments){
            System.out.println(productAccessment);
        }
    }
    
    @Test
    public void testQueryById(){
        ProductAccessment productAccessment = productAccessmentDao.queryById(1);
        System.out.println(productAccessment);
    }
    
}