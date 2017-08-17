package com.test.dao;

import com.fekpal.dao.UserDao;
import com.fekpal.domain.User;
import com.test.tool.XlsDataSetBeanFactory;

/**
 * Created by APone on 2017/8/16.
 */
public class UserDaoTest {

    private UserDao userDao;

    public void find() throws Exception {
        User user = XlsDataSetBeanFactory.createBean(UserDaoTest.class, "UserDao.Find.xls", "user", User.class);
        userDao.add(user);
    }
}
