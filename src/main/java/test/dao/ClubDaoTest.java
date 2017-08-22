package test.dao;

import com.fekpal.dao.ClubDao;
import com.fekpal.dao.UserDao;
import com.fekpal.domain.Club;
import com.fekpal.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * Created by APone on 2017/8/21.
 */
public class ClubDaoTest extends BaseDaoTest {

    @Autowired
    ClubDao clubDao;

    @Autowired
    UserDao userDao;

    private Club club = new Club();

    private User user = new User();

    @Before
    public void init() {
        club.setAdminName("zj");
        club.setClubName("IT社");
        club.setFoundTime(Timestamp.valueOf("1996-1-2 01:01:01"));

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
    public void testClubDao() {
        userDao.addUser(user);

        club.setUserId(user.getUserId());
        clubDao.addClub(club);

        Assert.assertNull(clubDao.getClubByClubId(1));
        System.out.println((club = clubDao.getClubByClubId(club.getClubId())).toString());
        Assert.assertTrue(!clubDao.findClubByClubName("T社", 0, 2).isEmpty());
        Assert.assertTrue(clubDao.findClubByClubName("zj", 0, 2).isEmpty());


        System.out.println(clubDao.getClubByClubName(club.getClubName()).toString());
        Assert.assertNull(clubDao.getClubByClubName("asd"));
        Assert.assertNotNull(clubDao.getClubByUser(user));

        user.setUserId(1);
        Assert.assertNull(clubDao.getClubByUser(user));

        user.setUserId(club.getUserId());
        Assert.assertNotNull(clubDao.getClubByUser(user));

        clubDao.updateLikeNumber(club.getClubId());
        clubDao.updateLikeNumber(club.getClubId());
        clubDao.updateLikeNumber(club.getClubId());
        clubDao.updateLikeNumber(club.getClubId());

        System.out.println(club.toString());
        club = clubDao.getClubByUser(user);
        System.out.println(club.toString());

        Assert.assertFalse(clubDao.hadClubName("ip"));
        Assert.assertTrue(clubDao.hadClubName("IT社"));

        Assert.assertTrue(!clubDao.loadAllClub(0, 2).isEmpty());

        club.setClubName("呵呵社");
        clubDao.updateClub(club);
        Assert.assertNotNull(clubDao.getClubByClubName("呵呵社"));
        Assert.assertNull(clubDao.getClubByClubName("IT社"));
        System.out.println(clubDao.getClubByClubName("呵呵社").toString());
    }

    public ClubDao getClubDao() {
        return clubDao;
    }

    public void setClubDao(ClubDao clubDao) {
        this.clubDao = clubDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
