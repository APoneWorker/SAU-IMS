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

    /**
     * 根据用户id查找user
     * @param userId int
     * @return User
     */
    @Override
    public User getUserByUserId(int userId) {
        String hql = "from User u where u.userId= ?";
        List<User> userList = find(hql, userId);
        return userList.get(0);
    }


    /**
     *根据用户名查找user
     * @param userName String
     * @return User
     */
    @Override
    public User findUserByUserName(String userName) {
        String hql = "from User u where u.userName = ?";
        List<User> userList = find(hql, userName);
        return userList.get(0);
    }

    /**
     * 根据用户名和密码查找用户
     * @param userName String
     * @param password String
     * @return User
     */
    @Override
    public User findUserByUserNameAndPassword(String userName, String password) {
        String hql = "from User u where u.userName = ? and u.password = ?";
        List<User> userList = find(hql, userName, password);
        return userList.get(0);
    }

    /**
     * 根据邮箱查找用户
     * @param email String
     * @return User
     */
    @Override
    public User findUserByEmail(String email) {
        String hql = "from User u where u.email =?";
        List<User> userList = find(hql, email);
        return userList.get(0);
    }

    /**
     * 是否存在用户名相同的用户
     * @param userName String
     * @return boolean
     */
    @Override
    public boolean hadAccount(String userName) {
        String hql = "select count(*) from User u where u.userName = ?";
        int count = find(hql, userName).size();
        return count > 0;
    }

    /**
     * 是否存在相同邮箱
     * @param email String
     * @return boolean
     */
    @Override
    public boolean hadEmail(String email) {
        String hql = "select count(*) from User u where u.email = ?";
        int count = find(hql, email).size();
        return count > 0;
    }
}
