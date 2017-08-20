package com.fekpal.dao;

import com.fekpal.domain.Sau;
import com.fekpal.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by APone on 2017/8/15.
 * SauDao的接口
 */
@Repository
public interface SauDao {

    /**
     * 根据校社联用户获取校社联信息
     *
     * @param user User
     * @return Sau
     */
    Sau getSauByUser(User user);


    /**
     * 根据校社联id获取校社联
     *
     * @param sauId int
     * @return Sau
     */
    Sau getSauBySauId(int sauId);

    /**
     * 添加校社联
     *
     * @param sau Sau
     */
    void addSau(Sau sau);

    /**
     * 更新校社联信息
     *
     * @param sau Sau
     */
    void updateSau(Sau sau);

    /**
     * 获得所有的校社联
     *
     * @return Sau
     */
    Sau loadAllSau();
}
