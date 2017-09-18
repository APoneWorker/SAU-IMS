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
            clubs.setClubId(club.getClubId());
            clubs.setClubView(club.getClubView());
            clubs.setDescription(club.getDescription());
            clubs.setLikeNumber(club.getLikeNumber());
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

        club1.setClubId(club.getClubId());
        club1.setAdminName(club.getAdminName());
        club1.setClubLogo(club.getLogo());
        club1.setClubName(club.getClubName());
        club1.setDescription(club.getDescription());
        club1.setEmail(club.getEmail());
        club1.setFoundTime(new Date(club.getFoundTime().getTime()));
        club1.setMembers(club.getMembers());
        //将某个社团详细信息加入到数据中
        returnData.setData(club1);

        return returnData.getMap();
    }
}

