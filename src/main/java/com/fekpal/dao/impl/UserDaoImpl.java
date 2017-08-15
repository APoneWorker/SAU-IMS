package com.fekpal.dao.impl;

import com.fekpal.domain.User;

/**
 * Created by APone on 2017/8/15.
 * userDao接口
 */
public interface UserDaoImpl {

    User queryUserByUserName(String userName);

    User queryUserByUserNameAndPassword(String userName, String password);

    User queryUserByEmail(String email);

    boolean hadAccount(String userName);

    boolean hadEmail(String email);

    boolean addUser(User user);
}
