package com.fekpal.dao;

import com.fekpal.domain.Club;

import java.util.List;

/**
 * Created by APone on 2017/8/15.
 * ClubDao的接口
 */
public interface ClubDao {

    Club getClubByClubId(int clubId);

    Club findClubByClubName(String clubName);

    Club findClubByUserId(int userId);

    boolean hadClubName(String clubName);

    List<Club> getAllClubIdentify();
}
