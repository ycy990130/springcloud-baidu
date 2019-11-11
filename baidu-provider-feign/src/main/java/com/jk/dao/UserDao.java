package com.jk.dao;

import com.jk.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> AllUserCount(@Param("u") User user);

    List<User> queryUser(@Param("u")User user, @Param("firstNum")Integer firstNum, @Param("lastNum")Integer lastNum);
}
