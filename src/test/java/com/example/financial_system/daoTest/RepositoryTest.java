package com.example.financial_system.daoTest;

import com.example.financial_system.entity.Repository;
import java.util.List;
import com.example.financial_system.dao.RepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 单元测试类
 *
 * @author laidilin
 * @since 2020-06-08 01:23:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RepositoryTest {

    @Autowired
    private RepositoryDao repositoryDao;
    
    @Test
    public void testQueryAll(){
        List<Repository> repositorys = repositoryDao.queryAll();
        for(Repository repository : repositorys){
            System.out.println(repository);
        }
    }
    
    @Test
    public void testQueryAllByLimit(){
        List<Repository> repositorys = repositoryDao.queryAllByLimit(0,1);
        for(Repository repository : repositorys){
            System.out.println(repository);
        }
    }
    
    @Test
    public void testQueryById(){
        Repository repository = repositoryDao.queryById(1);
        System.out.println(repository);
    }
    
}