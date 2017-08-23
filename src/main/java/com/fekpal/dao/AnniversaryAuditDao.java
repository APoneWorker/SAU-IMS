package com.fekpal.dao;

import com.fekpal.domain.AnniversaryAudit;
import com.fekpal.domain.Club;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by APone on 2017/8/23.
 * AnniversaryAuditDao接口
 */
@Repository
public interface AnniversaryAuditDao {

    /**
     * 根据审核id获得审核
     *
     * @param annId int
     * @return AnniversaryAudit
     */
    AnniversaryAudit getAnnByAnnId(int annId);

    /**
     * 根据社团获得所有有关的审核
     *
     * @param club Club
     * @return List
     */
    List<AnniversaryAudit> getAnnByClub(Club club, int start, int count);

    /**
     * 根据社团获得当前待审核的审核（或许没有）
     *
     * @param club Club
     * @return AnniversaryAudit
     */
    AnniversaryAudit getAnnAuditingByClub(Club club);

    /**
     * 根据社团名称搜索所有审核，时间和未审核排列优先
     *
     * @param clubName String
     * @return List
     */
    List<AnniversaryAudit> findAnnByClubName(String clubName, int start, int count);

    /**
     * 添加审核
     *
     * @param anniversaryAudit AnniversaryAudit
     */
    void addAnniversaryAudit(AnniversaryAudit anniversaryAudit);

    /**
     * 更新审核信息
     *
     * @param anniversaryAudit AnniversaryAudit
     */
    void updateAnniversaryAudit(AnniversaryAudit anniversaryAudit);

    /**
     * 获取所有审核,时间和未审核排列优先
     *
     * @return List
     */
    List<AnniversaryAudit> loadAllAnniversaryAudit(int start, int count);

    /**
     * 根据审核状态获得相应的审核列表
     *
     * @param state int
     * @param start int
     * @param end   int
     * @return List
     */
    List<AnniversaryAudit> getAnniversaryAuditByState(int state, int start, int end);

}
