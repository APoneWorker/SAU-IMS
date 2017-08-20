package test.dao;

import com.fekpal.dao.ClubDao;
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

    private Club club = new Club();

    private User user = new User();

    @Before
    public void init() {
        club.setAdminName("zj");
        club.setClubName("IT社");
        club.setFoundTime(Timestamp.valueOf("1996-1-2 01:01:01"));
        user.setUserId(22);
        club.setUser(user);
    }

    @Test
    public void testClubDao() {
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

        user.setUserId(22);
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
