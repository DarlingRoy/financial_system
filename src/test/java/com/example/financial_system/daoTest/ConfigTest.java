package com.example.financial_system.daoTest;

import java.util.List;
import com.example.financial_system.dao.ConfigDao;
import com.example.financial_system.entity.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:19:48
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConfigTest {

    @Autowired
    private ConfigDao configDao;
    
    @Test
    public void testQueryAll(){
        List<Config> configs = configDao.queryAll();
        for(Config config : configs){
            System.out.println(config);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<Config> configs = configDao.queryAllByLimit(0,1);
        for(Config config : configs){
            System.out.println(config);
        }
    }
    
    @Test
    public void testQueryById(){
        Config config = configDao.queryById(1);
        System.out.println(config);
    }
    
}