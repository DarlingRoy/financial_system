package com.example.financial_system.daoTest;

import com.example.financial_system.entity.Product;
import java.util.List;
import java.util.Map;

import com.example.financial_system.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-11 21:30:40
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {

    @Autowired
    private ProductDao productDao;
    
    @Test
    public void testQueryAll(){
        List<Product> products = productDao.queryAll();
        for(Product product: products){
            System.out.println(product);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<Product> products = productDao.queryAllByLimit(0,1);
        for(Product product : products){
            System.out.println(product);
        }
    }
    
    @Test
    public void testQueryById(){
        Product product = productDao.queryById(1);
        System.out.println(product);
    }

    
}