package com.fekpal.dao;

import com.fekpal.dao.impl.SauDaoImpl;
import com.fekpal.domain.Sau;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by APone on 2017/8/15.
 */
@Repository
public class SauDao extends BaseDao<Sau> implements SauDaoImpl {

    /**
     * 获得校社联信息
     *
     * @return Sau
     */
    @Override
    public Sau getSau() {
        return loadAll().get(0);
    }

    /**
     * 获取校社联身份标识，名称和id
     *
     * @return Sua
     */
    @Override
    public Sau getAllSauIdentify() {
        String hql = "select s.user.userId, s.sauId, s.sauName from Sau s";
        List<Sau> sauList=find(hql);
        return sauList.get(0);
    }
}
