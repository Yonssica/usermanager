package cn.itcast.usermanager.mapper;

import cn.itcast.usermanager.pojo.User;
import com.github.abel533.entity.Example;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Yonssica on 2017/8/11.
 */
public class NewUserMapperTest {

    private NewUserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
                "spring/applicationContext-mybatis.xml");
        this.userMapper = context.getBean(NewUserMapper.class);
    }

    @Test
    public void testSelectByExample() {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLessThan("age", 30);
        example.or(example.createCriteria().andGreaterThan("birthday", 1990 - 10 - 10));
        example.setOrderByClause("age desc,birthday asc");
        List<User> userList = this.userMapper.selectByExample(example);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}