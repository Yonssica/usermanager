package cn.itcast.usermanager.mapper;

import cn.itcast.usermanager.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hwd on 2017/8/8.
 */
public class UserMapperTest {
    public UserMapper userMapper;

    @Before
    public void setUp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
                "spring/applicationContext-mybatis.xml");
        this.userMapper = context.getBean(UserMapper.class);
    }

    @Test
    public void testQueryUserById() {
        System.out.println(this.userMapper.queryUserById(1l));
    }
}
