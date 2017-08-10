package cn.itcast.usermanager.controller;

import cn.itcast.usermanager.pojo.EasyUIResult;
import cn.itcast.usermanager.pojo.User;
import cn.itcast.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hwd on 2017/8/8.
 */
@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("users")
    public String toUsers() {
        return "users";
    }

    @RequestMapping("/page/{pageName}")
    public String toUserAdd(@PathVariable("pageName") String pageName) {
        return pageName;
    }

    @RequestMapping("list")
    @ResponseBody
    public EasyUIResult queryUsersByPage(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer
            pageSize) {
        return this.userService.queryEasyUIResult(pageNum, pageSize);
    }

    @RequestMapping("save")
    @ResponseBody
    public Map<String, Object> addUser(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 调用UserService的新增用户方法
            Boolean b = this.userService.addUser(user);
            if (b) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("edit")
    @ResponseBody
    public Map<String, Object> editUser(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 调用UserService的修改用户方法
            Boolean b = this.userService.editUser(user);
            if (b) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Map<String, Object> deleteUser(@RequestParam("ids") String[] ids) {
        Map<String, Object> map = new HashMap<>();
        try {
            // 调用UserService的新增用户方法
            Boolean b = this.userService.deleteUser(ids);
            if (b) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("export/excel")
    public String exportExcel(@RequestParam("rows") Integer pageSize, @RequestParam("page") Integer pageNum, Model
            model) {
        // 查询分页数据
        EasyUIResult easyUIResult = this.userService.queryEasyUIResult(pageNum, pageSize);
        // 添加数据模型
        List<User> userList = (List<User>) easyUIResult.getRows();
        model.addAttribute("userList", userList);
        // 返回视图名称
        return "userExcelView";
    }
}
