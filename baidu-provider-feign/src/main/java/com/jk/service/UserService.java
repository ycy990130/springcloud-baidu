package com.jk.service;

import com.jk.model.User;

import java.util.List;

public interface UserService {

    List<User> AllUserCount(User user);

    List<User> queryUser(User user, Integer firstNum, Integer lastNum);
}
