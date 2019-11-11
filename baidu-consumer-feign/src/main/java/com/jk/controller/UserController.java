package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserServiceFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UserServiceFeign userServiceFeign;
    //查询
    @RequestMapping("queryUser")
    @ResponseBody
    public Map<String,Object> queryUser(Integer page, Integer rows, User user, HttpServletResponse response) throws IOException {
        Map<String,Object> userList=userServiceFeign.queryUser(page,rows,user);
        if(userList == null){
            /* 设置格式为text/json */
            response.setContentType("text/json");
            /* 设置字符集为'UTF-8' */
            response.setCharacterEncoding("UTF-8");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("网络异常！！！");
            printWriter.flush();
            printWriter.close();
        }
        return userList;
    }
    //查询页面
    @RequestMapping("userShow")
    public String userShow(){
        return "userShow";
    }
}
