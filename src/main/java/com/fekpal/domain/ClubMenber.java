package com.fekpal.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "club_member")
public class ClubMenber extends BasePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "member_duty")
    private int memberDuty;

    @Column(name = "user_state")
    private int userState;

    @Column(name = "join_time")
    private Timestamp joinTime;

    private String description;

    @Column(name = "leave_time")
    private Timestamp leaveTime;

    @Column(name = "club_department")
    private String clubDepartment;

    private int avaliable;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getMemberDuty() {
        return memberDuty;
    }

    public void setMemberDuty(int memberDuty) {
        this.memberDuty = memberDuty;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public Timestamp getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Timestamp leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getClubDepartment() {
        return clubDepartment;
    }

    public void setClubDepartment(String clubDepartment) {
        this.clubDepartment = clubDepartment;
    }

    public int getAvaliable() {
        return avaliable;
    }

    public void setAvaliable(int avaliable) {
        this.avaliable = avaliable;
    }
}
