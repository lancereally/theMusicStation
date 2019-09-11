package org.lanqiao.controller;

import org.lanqiao.entity.Share;
import org.lanqiao.service.ShareService;
import org.lanqiao.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/share")
public class ShareController {

    @Autowired
    ShareService shareService;

    @RequestMapping("/getAllShare")
    public List<Share> get(){
        List<Share> shareList = shareService.getAllShare();
        return shareList;
    }

    @RequestMapping("/addLikes")
    public Integer addLikes(@RequestParam Integer shareId){
        return shareService.updateShareLikesByPK(shareId);
    }

    @RequestMapping("/shareForward")
    public Integer insertShareForward(Share share){
        return shareService.insertShareForward(share);
    }

//
//    @RequestMapping("/getIP")
//    public String getIp(HttpServletRequest request){
//        //获取IP地址
//        String ipAddress = IpUtil.getIpAddr(request);
//        return ipAddress;
//    }


}
