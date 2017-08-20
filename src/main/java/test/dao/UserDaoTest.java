package test.dao;

import com.fekpal.dao.UserDao;
import com.fekpal.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.junit.Assert.assertTrue;

/**
 * Created by APone on 2017/8/16.
 */
@Rollback
@Transactional(transactionManager = "txManager")
public class UserDaoTest extends BaseDaoTest {

    @Autowired
    private UserDao userDao;

    private User user = new User();

    @Before
    public void init() {
        user.setUserName("zjboy");
        user.setPassword("123456");
        user.setEmail("zjboy@163.com");
        user.setPhone("12345678901");
        user.setUserKey("123456");
        user.setLoginTime(Timestamp.valueOf("1996-02-01 01:02:01"));
        user.setLoginIp("0.0.0.0");
        user.setRegisterTime(Timestamp.valueOf("1992-01-02 01:02:09"));
        user.setRegisterIp("0.0.0.0");
        user.setAuthority(0);
        user.setUserState(1);
    }

    @Test
    public void testUserDao() {
        userDao.addUser(user);
        System.out.println(userDao.getUserByEmail("zjboy@163.com").toString());
        System.out.println(userDao.getUserByUserId(user.getUserId()).toString());
        System.out.println(userDao.getUserByUserName("zjboy").toString());
        System.out.println(userDao.getUserByUserNameAndPassword("zjboy", "123456").toString());

        Assert.assertNull("error1", userDao.getUserByEmail("zj"));
        Assert.assertNull("error2", userDao.getUserByUserId(0));
        Assert.assertNull("error3", userDao.getUserByUserName("s"));
        Assert.assertNull("error4", userDao.getUserByUserNameAndPassword("12", "43"));
        Assert.assertNull("error5", userDao.getUserByUserNameAndPassword("12", "123456"));
        Assert.assertNull("error6", userDao.getUserByUserNameAndPassword("zjboy", "43"));

        Assert.assertTrue(userDao.hadAccount("zjboy"));
        Assert.assertTrue(userDao.hadEmail("zjboy@163.com"));
        Assert.assertFalse(userDao.hadAccount("zjbo"));
        Assert.assertFalse(userDao.hadEmail("zjboy@163.co"));

        user.setPassword("12");
        userDao.updateUser(user);
        System.out.println(user.toString());

        Assert.assertNull("密码错误", userDao.getUserByUserNameAndPassword("zjboy", "123456"));
        Assert.assertNotNull("密码正确", userDao.getUserByUserNameAndPassword("zjboy", "12"));
        System.out.println(userDao.getUserByUserNameAndPassword("zjboy", "12").toString());
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
