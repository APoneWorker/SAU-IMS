package test.dao;

import com.fekpal.dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static test.dao.Domain.user;

/**
 * Created by APone on 2017/8/16.
 */
public class UserDaoTest extends BaseDaoTest {

    @Autowired
    private UserDao userDao;


    @Before
    public void init() {
        userDao.addUser(user);
    }

    @Test
    public void testUserDao() {

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
}
