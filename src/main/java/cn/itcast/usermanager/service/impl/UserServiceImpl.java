package cn.itcast.usermanager.service.impl;

import cn.itcast.usermanager.mapper.UserMapper;
import cn.itcast.usermanager.pojo.EasyUIResult;
import cn.itcast.usermanager.pojo.User;
import cn.itcast.usermanager.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hwd on 2017/8/8.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize) {
        // 在查询方法调用之前，调用分页插件的静态代码，中间最好不要隔任何代码
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = this.userMapper.queryUsersAll();
        // 初始化pageInfo对象，所有分页参数都可以在该对象中获取
        PageInfo<User> pageInfo = new PageInfo<User>(list);

        EasyUIResult easyUIResult = new EasyUIResult();
        easyUIResult.setTotal(pageInfo.getTotal());
        easyUIResult.setRows(pageInfo.getList());
        return easyUIResult;
    }

    @Override
    public void addUsers(User user1, User user2) {
        this.userMapper.addUser(user1);
        // 制造异常
        //  int i = 1/0;
        this.userMapper.addUser(user2);
    }

    @Override
    public Boolean addUser(User user) {
        int count = this.userMapper.addUser(user);
        if (count > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUser(String[] ids) {
        int index = this.userMapper.deleteUser(ids);
        if (index > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean editUser(User user) {
        int count = this.userMapper.editUser(user);
        if (count > 0) {
            return true;
        }
        return false;
    }
}
