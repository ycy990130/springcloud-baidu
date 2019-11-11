package com.jk.service;

import com.jk.dao.UserDao;
import com.jk.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override
    public List<User> AllUserCount(User user) {
        return userDao.AllUserCount(user);
    }

    @Override
    public List<User> queryUser(User user, Integer firstNum, Integer lastNum) {
        return userDao.queryUser(user,firstNum,lastNum);
    }
}
