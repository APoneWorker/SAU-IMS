package com.fekpal.dao;

import com.fekpal.domain.User;

import java.util.List;

/**
 * Created by APone on 2017/8/15.
 * userDao接口
 */
public interface UserDao {

    User getUserByUserId(int user_id);

    User findUserByUserName(String userName);

    User findUserByUserNameAndPassword(String userName, String password);

    User findUserByEmail(String email);

    boolean hadAccount(String userName);

    boolean hadEmail(String email);
}
