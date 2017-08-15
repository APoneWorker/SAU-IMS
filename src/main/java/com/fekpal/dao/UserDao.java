package com.fekpal.dao;

import com.fekpal.dao.impl.UserDaoImpl;
import com.fekpal.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by APone on 2017/8/15.
 * user的DAO层实现
 */
@Repository
public class UserDao extends BaseDao<User> implements UserDaoImpl {


    public User queryUserByUserName(String userName) {
        String hql = "from User u where u.userName = ?";
        List<User> userList = find(hql, userName);
        return userList.get(0);
    }

    public User queryUserByUserNameAndPassword(String userName, String password) {
        String hql = "from User u where u.userName = ? and u.password = ?";
        List<User> userList = find(hql, userName, password);
        return userList.get(0);
    }

    public User queryUserByEmail(String email) {
        String hql = "from User u where u.email =?";
        List<User> userList = find(hql, email);
        return userList.get(0);
    }

    public boolean hadAccount(String userName) {
        String hql = "select count(*) from User u where u.userName = ?";
        int count = find(hql, userName).size();
        return count > 0;
    }

    public boolean hadEmail(String email) {
        String hql = "select count(*) from User u where u.email = ?";
        int count = find(hql, email).size();
        return count > 0;
    }
}
