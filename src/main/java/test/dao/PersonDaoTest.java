package test.dao;

import com.fekpal.dao.PersonDao;
import com.fekpal.dao.UserDao;
import com.fekpal.domain.Person;
import com.fekpal.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by APone on 2017/8/28.
 */
public class PersonDaoTest extends BaseDaoTest {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private UserDao userDao;

    private User user = new User();

    private Person person = new Person();

    @Before
    public void init() {

    }

    @Test
    public void testPersonDao() {

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
