package test.dao;

import com.fekpal.dao.ClubDao;
import com.fekpal.dao.PersonDao;
import com.fekpal.dao.UserDao;
import com.fekpal.domain.Person;
import com.fekpal.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

import static test.dao.Domain.club;
import static test.dao.Domain.person;
import static test.dao.Domain.user;

/**
 * Created by APone on 2017/8/28.
 */
public class PersonDaoTest extends BaseDaoTest {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ClubDao clubDao;

    @Before
    public void init() {
        userDao.addUser(user);
        person.setUserId(user.getUserId());
        personDao.addPerson(person);
        clubDao.addClub(club);
    }

    @Test
    public void testPersonDao() {

        Person p = personDao.getPersonByNickName("佳佳");
        Assert.assertNotNull(p);
        System.out.println(p);
        p = personDao.getPersonByNickName("1");
        Assert.assertNull(p);

        p = personDao.getPersonByPersonId(person.getPersonId());
        Assert.assertNotNull(p);
        System.out.println(p);
        p = personDao.getPersonByPersonId(0);
        Assert.assertNull(p);

        p = personDao.getPersonByUserId(user.getUserId());
        Assert.assertNotNull(p);
        System.out.println(p);
        p = personDao.getPersonByUserId(0);
        Assert.assertNull(p);

        personDao.addLikeClub(user.getUserId(), club.getClubId());
        personDao.addLikeClub(user.getUserId(), 2);//不存在的社团id

        Assert.assertTrue(personDao.hadNickName("佳佳"));
        Assert.assertFalse(personDao.hadNickName("1"));

        List<Integer> integerList = personDao.loadAllLikeByUserId(user.getUserId());
        System.out.println(integerList.size());
        System.out.println(integerList);
        integerList = personDao.loadAllLikeByUserId(0);
        System.out.println(integerList.size());

        List<Person> personList = personDao.loadAllPerson(0, 2);
        System.out.println(personList.size());
        System.out.println(personList);

        p = personDao.getPersonByUserId(user.getUserId());
        p.setNickname("哈哈");
        personDao.updatePerson(p);
        p = personDao.getPersonByNickName("哈哈");
        System.out.println(p);

    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}