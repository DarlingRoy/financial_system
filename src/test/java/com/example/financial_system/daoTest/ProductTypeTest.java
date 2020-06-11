package com.example.financial_system.daoTest;

import com.example.financial_system.entity.ProductType;
import java.util.List;
import com.example.financial_system.dao.ProductTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-11 21:30:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTypeTest {

    @Autowired
    private ProductTypeDao productTypeDao;
    
    @Test
    public void testQueryAll(){
        List<ProductType> productTypes = productTypeDao.queryAll();
        for(ProductType productType : productTypes){
            System.out.println(productType);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<ProductType> productTypes = productTypeDao.queryAllByLimit(0,1);
        for(ProductType productType : productTypes){
            System.out.println(productType);
        }
    }
    
    @Test
    public void testQueryById(){
        ProductType productType = productTypeDao.queryById(1);
        System.out.println(productType);
    }
    
}