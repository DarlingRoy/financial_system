package com.example.financial_system.daoTest;

import com.example.financial_system.entity.ConfigAssessment;
import java.util.List;
import com.example.financial_system.dao.ConfigAssessmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:20:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConfigAssessmentTest {

    @Autowired
    private ConfigAssessmentDao configAssessmentDao;
    
    @Test
    public void testQueryAll(){
        List<ConfigAssessment> configAssessments = configAssessmentDao.queryAll();
        for(ConfigAssessment configAssessment : configAssessments){
            System.out.println(configAssessment);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<ConfigAssessment> configAssessments = configAssessmentDao.queryAllByLimit(0,1);
        for(ConfigAssessment configAssessment : configAssessments){
            System.out.println(configAssessment);
        }
    }
    
    @Test
    public void testQueryById(){
        ConfigAssessment configAssessment = configAssessmentDao.queryById(1);
        System.out.println(configAssessment);
    }
    
}