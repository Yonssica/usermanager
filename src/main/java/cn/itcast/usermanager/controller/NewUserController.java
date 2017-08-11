package cn.itcast.usermanager.controller;

import cn.itcast.usermanager.pojo.User;
import cn.itcast.usermanager.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Yonssica on 2017/8/11.
 */
@Controller
@RequestMapping("rest/user")
public class NewUserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<User> queryUserById(@PathVariable("id")Long id) {
        try {
            if (id.longValue() < 1) {
                // 400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
            User user = this.userService.queryUserById(id);
            if (user == null) {
                // 资源不存在：404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            // 200
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 新增用户数据
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveUser(User user) {
        try {
            if (StringUtils.isBlank(user.getUserName())) {
                // 400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            Boolean b  = this.userService.addUser(user);
            if (b) {
                // 201
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 更新用户数据
     * @param user
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateUser(User user) {
        try {
            if (user.getId() == null || user.getId().longValue() < 1) {
                // 400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            this.userService.editUser(user);
            // 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 删除用户数据
     * @param ids
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@RequestParam(value = "ids") List<Object> ids) {
        try {
            if (ids == null || ids.size() == 0) {
                // 400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            this.userService.deleteUser(ids);
            // 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
