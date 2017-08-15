package com.fekpal.dao;

import com.fekpal.dao.impl.ClubDaoImpl;
import com.fekpal.domain.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by APone on 2017/8/15.
 */
@Repository
public class ClubDao extends BaseDao<Club> implements ClubDaoImpl {

    /**
     * 根据社团id查找社团
     * @param clubId int
     * @return Club
     */
    @Override
    public Club getClubByClubId(int clubId) {
        String hql = "from Club c where c.clubId = ?";
        List<Club> clubList = find(hql, clubId);
        return clubList.get(0);
    }

    /**
     * 根据社团名查找社团
     * @param clubName String
     * @return Club
     */
    @Override
    public Club findClubByClubName(String clubName) {
        String hql = "from Club c where c.clubName = ?";
        List<Club> clubList = find(hql, clubName);
        return clubList.get(0);
    }

    /**
     * 根据账号id查找社团
     * @param userId int
     * @return Club
     */
    @Override
    public Club findClubByUserId(int userId) {
        String hql = "from Club c where c.user.userId = ?";
        List<Club> clubList = find(hql, userId);
        return clubList.get(0);
    }

    /**
     * 是否存在相同的社团名称
     * @param clubName String
     * @return boolean
     */
    @Override
    public boolean hadClubName(String clubName) {
        String hql = "from Club c where c.clubName = ?";
        List<Club> clubList = find(hql, clubName);
        return clubList.size() > 0;
    }

    /**
     * 获取社团的账号标识以及名称
     * @return List<Club>
     */
    @Override
    public List<Club> getAllClubIdentify() {
        String hql="select c.user.userId, c.clubId, c.clubName from Club c";
        return find(hql);
    }
}
