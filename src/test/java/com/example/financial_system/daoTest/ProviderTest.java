package com.example.financial_system.daoTest;

import com.example.financial_system.entity.Provider;
import java.util.List;
import com.example.financial_system.dao.ProviderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:23:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProviderTest {

    @Autowired
    private ProviderDao providerDao;
    
    @Test
    public void testQueryAll(){
        List<Provider> providers = providerDao.queryAll();
        for(Provider provider : providers){
            System.out.println(provider);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<Provider> providers = providerDao.queryAllByLimit(0,1);
        for(Provider provider : providers){
            System.out.println(provider);
        }
    }
    
    @Test
    public void testQueryById(){
        Provider provider = providerDao.queryById(1);
        System.out.println(provider);
    }
    
}