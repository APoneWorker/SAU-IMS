package com.fekpal.dao;

import com.fekpal.dao.impl.PersonDaoImpl;
import com.fekpal.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by APone on 2017/8/15.
 */
@Repository
public class PersonDao extends BaseDao<Person> implements PersonDaoImpl {

    /**
     *根据个人id查找个人
     * @param personId int
     * @return Person
     */
    @Override
    public Person getPersonByPersonId(int personId) {
        String hql = "from Person p where p.personId = ?";
        List<Person> personList = find(hql, personId);
        return personList.get(0);
    }


    /**
     * 根据真实名字查找个人
     * @param realName String
     * @return Person
     */
    @Override
    public Person getPersonByRealName(String realName) {
        String hql = "from Person p where p.user.realName = ?";
        List<Person> personList = find(hql, realName);
        return personList.get(0);
    }

    /**
     * 根据用户id查找个人
     * @param userId int
     * @return Person
     */
    @Override
    public Person getPersonByUserId(int userId) {
        String hql = "from Person p where p.user.userId = ?";
        List<Person> personList = find(hql, userId);
        return personList.get(0);
    }

    /**
     * 是否有相同昵称
     * @param nickName String
     * @return boolean
     */
    @Override
    public boolean hadNickName(String nickName) {
        String hql = "from Person p where p.nickName = ?";
        List<Person> personList = find(hql, nickName);
        return personList.size() > 0;
    }

    /**
     * 获取所有个人标识
     * @return List<Person>
     */
    @Override
    public List<Person> getAllPersonIdentify() {
        String sql = "select p.user.userId, p.personId, p.realName from Person p";
        return find(sql);
    }
}
