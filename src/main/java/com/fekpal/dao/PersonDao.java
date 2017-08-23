package com.fekpal.dao;

import com.fekpal.domain.Club;
import com.fekpal.domain.Person;
import com.fekpal.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by APone on 2017/8/15.
 * PersonDao的接口,个人普通用户信息，校社联用户和社团以此类推
 */
@Repository
public interface PersonDao {

    /**
     * 根据社团id获得个人
     *
     * @param personId int
     * @return Person
     */
    Person getPersonByPersonId(int personId);

    /**
     * 根据昵称获得个人
     *
     * @param nickName String
     * @return Person
     */
    Person getPersonByNickName(String nickName);

    /**
     * 根据用户获得个人
     *
     * @param user User
     * @return Person
     */
    Person getPersonByUser(User user);

    /**
     * 是否有相同的昵称
     *
     * @param nickName String
     * @return boolean
     */
    boolean hadNickName(String nickName);

    /**
     * 更新个人
     *
     * @param person Person
     */
    void updatePerson(Person person);

    /**
     * 添加喜爱社团
     *
     * @param user User
     * @param club Club
     */
    void addLikeClub(User user, Club club);

    /**
     * 获得所有喜爱的社团id
     *
     * @param user User
     * @return List
     */
    List<Integer> loadAllLikeClub(User user);

    /**
     * 获得所有个人
     *
     * @param start int
     * @param count int
     * @return List
     */
    List<Person> loadAllPerson(int start, int count);
}
