package org.lanqiao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.json.JSONException;
import org.lanqiao.entity.Share;
import org.lanqiao.entity.Singer;
import org.lanqiao.entity.Users;
import org.lanqiao.service.ShareService;
import org.lanqiao.service.SingerService;
import org.lanqiao.service.UsersService;
import org.lanqiao.util.GetPlaceByIp;
import org.lanqiao.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareController {

    @Autowired
    ShareService shareService;

    @Autowired
    UsersService usersService;

    @Autowired
    SingerService singerService;


//    @RequestMapping("/apiTest")
//    @ResponseBody
//    public String test(HttpServletRequest request) throws IOException, JSONException {
//        String m = new GetPlaceByIp().getPlace(request);
//        return m;
//    }


    @RequestMapping("/getAllShare")
    public PageInfo get(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){

        PageHelper.startPage(pageNum, 3);

        List<Share> shareList = shareService.getAllShare();

        PageInfo<Share> pageInfo = new PageInfo<>(shareList);

        return pageInfo;
    }

    @RequestMapping("/addLikes")
    public Integer addLikes(@RequestParam Integer shareId){
        return shareService.updateShareLikesByPK(shareId);
    }

    @RequestMapping("/shareForward")
    public Integer insertShareForward(Share share){
        return shareService.insertShareForward(share);
    }

    @RequestMapping("/getUser")
    public Users getUser(@RequestParam Integer userId){
        Users users = usersService.getShareUser_q(userId);
        return users;
    }

    @RequestMapping("/getStarUsers")
    public List<Singer> getStarUsers(){
        List<Singer> singerList = singerService.getStarByRand();
        return  singerList;
    }

    @RequestMapping("/gerOtherUsers")
    public List<Users> getOtherUsers(){
        return usersService.getOtherUsersByRand();
    }



//
//    @RequestMapping("/getIP")
//    public String getIp(HttpServletRequest request){
//        //获取IP地址
//        String ipAddress = IpUtil.getIpAddr(request);
//        return ipAddress;
//    }


}
