package test.dao;

import com.fekpal.dao.ClubDao;
import com.fekpal.domain.Club;
import com.fekpal.domain.ClubAudit;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * Created by APone on 2017/8/27.
 */
public class ClubAuditDao extends BaseDaoTest {

    @Autowired
    private ClubAuditDao clubAuditDao;

    @Autowired
    private ClubDao clubDao;

    private Club club = new Club();

    private ClubAudit clubAudit = new ClubAudit();

    @Before
    public void init() {
        club.setAdminName("zj");
        club.setClubName("IT社");
        club.setFoundTime(Timestamp.valueOf("1996-1-2 01:01:01"));


    }

    @Test
    public void testClubAudit() {
        clubDao.addClub(club);
    }

    public ClubAuditDao getClubAuditDao() {
        return clubAuditDao;
    }

    public void setClubAuditDao(ClubAuditDao clubAuditDao) {
        this.clubAuditDao = clubAuditDao;
    }

    public ClubDao getClubDao() {
        return clubDao;
    }

    public void setClubDao(ClubDao clubDao) {
        this.clubDao = clubDao;
    }
}
