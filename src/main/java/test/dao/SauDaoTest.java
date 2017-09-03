package test.dao;

import com.fekpal.dao.SauDao;
import com.fekpal.dao.UserDao;
import com.fekpal.domain.Sau;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static test.dao.Domain.sau;
import static test.dao.Domain.user;

/**
 * Created by APone on 2017/9/3.
 */
public class SauDaoTest extends BaseDaoTest {

    @Autowired
    private SauDao sauDao;

    @Autowired
    private UserDao userDao;

    @Before
    public void init() {
        userDao.addUser(user);
        sau.setUserId(user.getUserId());
        sauDao.addSau(sau);
    }

    @Test
    public void testSauDao() {
        sau = sauDao.getSauBySauId(sau.getSauId());
        Assert.assertNotNull(sau);
        System.out.println(sau);
        sau = sauDao.getSauBySauId(0);
        Assert.assertNull(sau);


        sau = sauDao.getSauByUserId(user.getUserId());
        Assert.assertNotNull(sau);
        System.out.println(sau);
        sau = sauDao.getSauByUserId(0);
        Assert.assertNull(sau);

        List<Sau> sauList = sauDao.loadAllSau();
        System.out.println(sauList.size());
        System.out.println(sauList);

        sau = sauDao.getSauByUserId(user.getUserId());
        sau.setMembers(sau.getMembers() + 1);
        sau.setAdminName("陈彦军");
        sauDao.updateSau(sau);
        sau = sauDao.getSauBySauId(sau.getSauId());
        System.out.println(sau);
    }

    public SauDao getSauDao() {
        return sauDao;
    }

    public void setSauDao(SauDao sauDao) {
        this.sauDao = sauDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
