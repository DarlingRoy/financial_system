package com.example.financial_system.daoTest;

import com.example.financial_system.dao.UserDao;
import com.example.financial_system.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author laidilin
 * @since 2020/6/8 0:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testQueryAll(){
        List<User> users = userDao.queryAll();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testQueryById(){
        User user=userDao.queryById(3);
        System.out.println(user);
    }

    @Test
    public void testQueryByLimit(){
        List<User> users=userDao.queryAllByLimit(0,5);
        for (User user:users){
            System.out.println(user);
        }
    }

    @Test
    public void testQueryByUsername(){
        User user = userDao.queryByUsername("马六");
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = userDao.queryByUsername("赵一");
        user.setUsername("林一");
        user.setPhone("15526987568");
        userDao.update(user);
        System.out.println(userDao.queryById(1));
    }

    @Test
    public void testInsertSelective(){
        User user = new User();
        user.setUsername("林七");
        user.setPhone("15998765432");
        user.setCreateTime(new Date());
        user.setIsDelete(false);
        userDao.insertSelective(user);
        System.out.println(userDao.queryById(7));
    }

    @Test
    public void testDelete(){
        userDao.deleteById(7);
        System.out.println(userDao.queryById(8));
    }

    @Test
    public void testCount(){
        System.out.println(userDao.countUser());
    }
}
