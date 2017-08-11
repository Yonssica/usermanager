package cn.itcast.usermanager.service;

import cn.itcast.usermanager.pojo.EasyUIResult;
import cn.itcast.usermanager.pojo.User;

import java.util.List;

/**
 * Created by hwd on 2017/8/8.
 */
public interface UserService {

    /**
     * 分页获取用户信息
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    EasyUIResult queryEasyUIResult(Integer pageNum, Integer pageSize);

    /**
     * 测试事务
     *
     * @param user1
     * @param user2
     */
    void addUsers(User user1, User user2);

    Boolean addUser(User user);

    Boolean deleteUser(List<Object> ids);

    Boolean editUser(User user);

    User queryUserById(Long id);

    void deleteUserById(Long id);
}
