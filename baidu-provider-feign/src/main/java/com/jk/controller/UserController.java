package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.service.UserServiceFeign;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController implements UserServiceFeign {
    @Resource
    private UserService userService;
    @RequestMapping("queryUser")
    @Override
    public Map<String, Object> queryUser(@RequestParam("page") Integer page, @RequestParam("rows")Integer rows, @SpringQueryMap User user) {
        Integer firstNum = (page-1)*rows;
        Integer lastNum = rows;
        Map m = new HashMap();
        List<User> Allcount = userService.AllUserCount(user);
        List<User> list = userService.queryUser(user,firstNum,lastNum);
        m.put("total",Allcount.size());
        m.put("rows",list);
        return m;
    }
}
