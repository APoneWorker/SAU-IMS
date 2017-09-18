package com.fekpal.web.controller.member;


import com.fekpal.cons.SystemRole;
import com.fekpal.domain.ClubMember;
import com.fekpal.domain.Person;
import com.fekpal.domain.User;
import com.fekpal.service.ClubMemberService;
import com.fekpal.service.PersonService;
import com.fekpal.tool.BaseReturnData;
import com.fekpal.tool.ImagesUploadTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static java.lang.System.out;

/**
 * 普通用户和社团成员端中心的控制类
 * Created by hasee on 2017/8/19.
 */
@Controller
public class MemberCenterController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ClubMemberService clubMemberService;

    /**
     * 得到普通成员和社团成员中心的信息的方法
     *
     * @param session 用户session
     * @return 普通成员或者社团成员的一些基本信息
     */
    @ResponseBody
    @RequestMapping("/member/center/info")
    public Map<String, Object> getMemberCenterMsg(HttpSession session) {

        BaseReturnData returnData = new BaseReturnData();
        User user = (User) session.getAttribute("userCode");

        //创建链表map集合存放普通成员中心信息
        Map<String, Object> memberCenterMsg = new LinkedHashMap<>();

        //模拟service层通过用户ID得到数据
        Person person = personService.getPersonAllInfoByUserId(user.getUserId());

        memberCenterMsg.put("userName", person.getUserName());
        memberCenterMsg.put("realName", person.getRealName());
        //从数据库中取出文件名
        memberCenterMsg.put("personLogo", person.getLogo());
        memberCenterMsg.put("studentID", person.getStudentId());
        memberCenterMsg.put("gender", SystemRole.GENDER[person.getGender()]);
        memberCenterMsg.put("birthday", new Date(person.getBirthday().getTime()));
        memberCenterMsg.put("phone", person.getPhone());
        memberCenterMsg.put("departmentName", person.getDepartment());
        memberCenterMsg.put("majorName", person.getMajor());
        memberCenterMsg.put("address", person.getAddress());

        //创建社团成员所属社团的list集合
        List<Map<String, Object>> clubsList = new ArrayList<>();
        List<ClubMember> members = clubMemberService.getClubMemberByPersonId(person.getPersonId());
        Map<String, Object> clubsMap;
        for (ClubMember member : members) {
            clubsMap = new LinkedHashMap<>();
            clubsMap.put("clubName", member.getClub().getClubName());
            clubsMap.put("clubDuty", member.getMemberDuty());
            clubsMap.put("userState", member.getUserState());
            clubsMap.put("joinTime", new Date(member.getJoinTime().getTime()));
            clubsMap.put("leaveTime", new Date(member.getLeaveTime().getTime()));
            clubsList.add(clubsMap);
        }
        memberCenterMsg.put("clubs", clubsList);

        //把用户数据添加到返回数据模板中
        returnData.setData(memberCenterMsg);

        return returnData.getMap();
    }

    /**
     * 上传成员个人头像的方法
     *
     * @param myfiles 文件对象，用from-data表单
     * @param request 请求
     * @return 图片文件名
     */
    @ResponseBody
    @RequestMapping(value = "/member/center/info/edit/head", method = RequestMethod.PUT)
    public Map<String, Object> uploadLogo(@RequestParam("file") MultipartFile[] myfiles, HttpServletRequest request, HttpSession session) {

        Map<String, Object> returnData = ImagesUploadTool.uploadImage(myfiles, request, "club//logo");
        //初始化社团头像文件名
        String memberLogoName = "";
        if ("0".equals(returnData.get("code").toString())) {
            Map<String, String> memberLogoNameMap = (Map<String, String>) returnData.get("data");
            memberLogoName = memberLogoNameMap.get("clubLogo");
            User user = (User) session.getAttribute("userCode");

            //将logo文件名存入数据库
            Person person = personService.getPersonByUserId(user.getUserId());
            person.setLogo(memberLogoName);
            personService.updatePerson(person);
            out.println("存入数据库logo的文件名：" + memberLogoName);

        }

        return returnData;
    }

    /**
     * 普通成员或者社团成员用来提交修改个人中心的信息
     *
     * @param memberCenterMsg 个人中心信息
     * @param session         会话
     * @return 是否提交成功
     */
    @ResponseBody
    @RequestMapping(value = "/member/center/info/edit", method = RequestMethod.PUT)
    public Map<String, Object> subNewCenterMsg(@RequestParam Map<String, Object> memberCenterMsg, HttpSession session) {

        out.println(memberCenterMsg);
        BaseReturnData returnData = new BaseReturnData();

        //得到用户id
        User user = (User) session.getAttribute("userCode");
        int userId = user.getUserId();
        Person person=personService.getPersonByUserId(userId);
        //注入数据
        personService.updatePerson(person);

        //将用户存入数据库
        out.println("用户id:" + userId);
        out.println("根据用户id存入数据库" + memberCenterMsg);

        return returnData.getMap();
    }
}












