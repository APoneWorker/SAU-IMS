package com.fekpal.web.controller;

import com.fekpal.cons.WebPath;
import com.fekpal.domain.Club;
import com.fekpal.domain.controller.ClubDetail;
import com.fekpal.domain.controller.ClubListMsg;
import com.fekpal.service.ClubService;
import com.fekpal.service.UserService;
import com.fekpal.tool.BaseReturnData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/**
 * 首页的控制类
 * Created by hasee on 2017/8/15.
 */
@Controller
@RequestMapping("/index")
public class IndexPageController {

    @Autowired
    private ClubService clubService;

    @Autowired
    private UserService userService;

    /**
     * 得到社团列表信息
     *
     * @return 社团列表信息（json数据）
     */
    @ResponseBody
    @RequestMapping(value = "/club")
    public Map<String, Object> getClubList() {

        //得到返回数据的模板
        BaseReturnData returnData = new BaseReturnData();

        // 创建封装社团列表信息的list集合
        List<ClubListMsg> list = new ArrayList<>();

        //从service中得到对象，获取对象属性，放入对应中
        List<Club> clubList = clubService.loadAllClub(0, 50);

        for (Club club : clubList) {

            ClubListMsg clubs = new ClubListMsg();
            //社团id
            clubs.setClubId(club.getClubId());
            //社团预览图
            clubs.setClubView(club.getClubView());
            //社团介绍
            clubs.setDescription(club.getDescription());
            //社团喜爱人数
            clubs.setLikeNumber(club.getLikeNumber());
            //社团人数
            clubs.setMembers(club.getMembers());
            //将社团加入到数据的list集合中
            list.add(clubs);
        }

        //将list加入到数据中
        returnData.setData(list);
        return returnData.getMap();
    }

    /**
     * 发送某个社团的详细信息
     *
     * @param clubId 接受社团ID
     * @return 返回社团详细信息json
     */
    @ResponseBody
    @RequestMapping(value = "/club/{clubId}")
    public Map<String, Object> getClubDetail(@PathVariable("clubId") Integer clubId) {

        //得到返回数据的模板
        BaseReturnData returnData = new BaseReturnData();

        Club club = clubService.getClubByClubId(clubId);

        ClubDetail club1 = new ClubDetail();
        //社团id
        club1.setClubId(club.getClubId());
        //社团社长名称
        club1.setAdminName(club.getAdminName());
        //社团logo
        club1.setClubLogo(club.getClubLogo());
        //社团名称
        club1.setClubName(club.getClubName());
        //社团介绍
        club1.setDescription(club.getDescription());
        //社团email
        club1.setEmail(userService.getUserByUserId(club.getUserId()).getEmail());
        //社团建立时间
        club1.setFoundTime(new Date(club.getFoundTime().getTime()));
        //社团人数
        club1.setMembers(club.getMembers());

        //将某个社团详细信息加入到数据中
        returnData.setData(club1);
        return returnData.getMap();
    }

    /**
     * 用于测试时间传输的格式和目录
     *
     * @param date 前端传递过来的描述
     * @return 返回时间格式
     */
    @RequestMapping("/time")
    @ResponseBody
    public Date testDate(@RequestParam Date date) {
        out.println(WebPath.consPath);
        out.println(WebPath.rootParentPath);

        out.println("格式化前" + date);
        out.println("格式化后" + new SimpleDateFormat("yyyy-MM-dd").format(date));
        return date;
    }
}

