package test.dao;

import com.fekpal.dao.impl.RoleDao;
import com.fekpal.domain.Authority;
import com.fekpal.domain.Resource;
import com.fekpal.domain.Role;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by APone on 2017/8/17.
 */
public class RoleDaoTest extends BaseDaoTest {

    @Before
    public void init() {

    }

    @Test
    public void testGetRole() {
        RoleDao roleDao = new RoleDao();
        Role role = roleDao.getRoleByAuthorityId(5);
        System.out.println(role.getRoleName());
        for (Authority authority : role.getAuthorityList()) {
            System.out.println(authority.getAuthorityId() + " " + authority.getAuthorityName() + " " + authority.getDescription());
            for (Resource resource : authority.getResourceList()) {
                System.out.println(resource.getResourceId() + " " + resource.getDescription() + " " + resource.getResourceURL());
            }
        }
    }
}
