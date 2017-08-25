package com.fekpal.dao;

import com.fekpal.domain.ClubMember;
import com.fekpal.domain.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by APone on 2017/8/23.
 * ClubMemberDao接口
 */
@Repository
public interface ClubMemberDao {


    /**
     * 根据用户id和社团id获得社员信息
     *
     * @param userId int
     * @param clubId int
     * @return ClubMember
     */
    ClubMember getMemberByUserAndCLb(int userId, int clubId);

    /**
     * 通过用户id获得所在所有参加社团
     *
     * @param userId int
     * @return List
     */
    List<ClubMember> getClubMemberByUserId(int userId);

    /**
     * 通过社团id获得所有社员
     *
     * @param cluId int
     * @return List
     */
    List<Person> getAllMemberByClubId(int cluId);

    /**
     * 添加新的社员
     *
     * @param clubMember ClubMember
     */
    void addClubMember(ClubMember clubMember);

    /**
     * 更新社员信息
     *
     * @param clubMember ClubMember
     */
    void updateClubMember(ClubMember clubMember);

    /**
     * 获得=所有所在社团社员的审核信息
     *
     * @param clubId int
     * @return List
     */
    List<ClubMember> getAllAuditingByClub(int clubId);
}
