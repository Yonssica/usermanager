package cn.itcast.usermanager.service;

import cn.itcast.usermanager.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by hwd on 2017/8/8.
 */
public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
                "spring/applicationContext-mybatis.xml", "spring/applicationContext-transaction.xml");
        this.userService = context.getBean(UserService.class);
    }

    @Test
    public void queryEasyUIResult() throws Exception {
    }

    @Test
    public void addUsers() throws Exception {
        User user1 = new User();
        user1.setUserName("maya1");
        user1.setPassword("123233");
        User user2 = new User();
        user2.setUserName("maya2");
        user2.setPassword("123233");
        this.userService.addUsers(user1,user2);
    }

}