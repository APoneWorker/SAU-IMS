package test.dao;

import com.fekpal.cons.MessageType;
import com.fekpal.cons.SystemRole;
import com.fekpal.domain.*;

import java.sql.Timestamp;

/**
 * Created by APone on 2017/9/3.
 */
public class Domain {

    public static User user = new User();

    public static User anUser = new User();

    public static Club club = new Club();

    public static Sau sau = new Sau();

    public static Person person = new Person();

    public static ClubAudit clubAudit = new ClubAudit();

    public static AnniversaryAudit anniversaryAudit = new AnniversaryAudit();

    public static Message message = new Message();

    public static Message message1 = new Message();

    public static MessageRelease messageRelease = new MessageRelease();

    public static MessageRelease messageRelease1 = new MessageRelease();

    public static ClubMember clubMember = new ClubMember();

    static {
        user.setUserName("zjboy");
        user.setPassword("123456");
        user.setEmail("zjboy@163.com");
        user.setPhone("12345678901");
        user.setUserKey("123456");
        user.setLoginTime(Timestamp.valueOf("1996-02-01 01:02:01"));
        user.setLoginIp("0.0.0.0");
        user.setRegisterTime(Timestamp.valueOf("1992-01-02 01:02:09"));
        user.setRegisterIp("0.0.0.0");
        user.setAuthority(SystemRole.CLUB);
        user.setUserState(1);

        anUser.setUserName("小仙女");
        anUser.setPassword("123456");
        anUser.setEmail("zjboy@163.com");
        anUser.setPhone("12345678901");
        anUser.setUserKey("123456");
        anUser.setLoginTime(Timestamp.valueOf("1996-02-01 01:02:01"));
        anUser.setLoginIp("0.0.0.0");
        anUser.setRegisterTime(Timestamp.valueOf("1992-01-02 01:02:09"));
        anUser.setRegisterIp("0.0.0.0");
        anUser.setAuthority(SystemRole.SAU);
        anUser.setUserState(1);

        person.setNickname("佳佳");

        club.setAdminName("zj");
        club.setClubName("IT社");
        club.setFoundTime(Timestamp.valueOf("1996-1-2 01:01:01"));

        clubAudit.setClub(club);
        clubAudit.setFile("java部落");
        clubAudit.setSendTime(Timestamp.valueOf("1996-06-09 00:01:02"));

        anniversaryAudit.setSubmitTime(Timestamp.valueOf("1996-06-09 01:01:01"));
        anniversaryAudit.setSubmitDescription("这是it社重改版本");
        anniversaryAudit.setFileName("434DUHWDU4234HU");
        anniversaryAudit.setClub(club);

        message.setMessageAnnex("附件");
        message.setMessageContent("百团大赛");
        message.setMessageTitle("紧急通知");
        message.setReleaseName("校社联");
        message.setMessageType(MessageType.ALL);
        message.setReleaseTime(Timestamp.valueOf("1996-06-09 00:01:02"));

        message1.setMessageContent("开学大典");
        message1.setMessageTitle("校内通知");
        message1.setReleaseName("It社");
        message1.setMessageType(MessageType.CUSTOM);
        message1.setReleaseTime(Timestamp.valueOf("1996-06-09 00:01:02"));

        clubMember.setJoinTime(Timestamp.valueOf("1995-01-06 12:12:12"));
    }
}
