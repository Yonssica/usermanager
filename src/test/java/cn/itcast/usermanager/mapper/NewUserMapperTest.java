package cn.itcast.usermanager.mapper;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by hwd on 2017/8/9.
 */
public class NewUserMapperTest {

    private NewUserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml\"," +
                "spring/applicationContext-mybatis.xml");
        this.userMapper = context.getBean(NewUserMapper.class);
    }

}