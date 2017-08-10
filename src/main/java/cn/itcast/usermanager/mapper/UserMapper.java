package cn.itcast.usermanager.mapper;

import cn.itcast.usermanager.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by hwd on 2017/8/8.
 */
public interface UserMapper {

    /**
     * 根据id获取用户信息
     */
    public User queryUserById(Long id);

    /**
     * 分页获取用户信息
     */
    public List<User> queryUsersByPage(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

    /**
     * 查询所有用户
     */
    public List<User> queryUsersAll();

    /**
     * 新增用户
     */
    public int addUser(User user);

    int deleteUser(@Param("ids") String[] ids);

    int editUser(User user);
}
