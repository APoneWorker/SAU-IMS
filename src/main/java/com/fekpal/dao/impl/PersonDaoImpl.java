package com.fekpal.dao.impl;

import com.fekpal.domain.Person;

import java.util.List;

/**
 * Created by APone on 2017/8/15.
 * PersonDao的接口
 */
public interface PersonDaoImpl {

    Person getPersonByPersonId(int personId);

    Person getPersonByRealName(String realName);

    Person getPersonByUserId(int userId);

    boolean hadNickName(String nickName);

    List<Person> getAllPersonIdentify();
}
