package org.lanqiao.controller;

import org.lanqiao.entity.Share;
import org.lanqiao.entity.Users;
import org.lanqiao.service.ShareService;
import org.lanqiao.service.ShareServiceImpl;
import org.lanqiao.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @Autowired
    ShareServiceImpl shareService;
//获取用户基本信息
    @RequestMapping("/user/getUserInfo")
    public Users getLittleInfo (Integer userId){
        return usersService.getLittleInfo(userId);
    }
//获取 动态数目
    @RequestMapping("/user/getEventCount")
    public List<Share> getEventCount (Integer userId){
        return shareService.getEventCount(userId);
    }
//获取关注数
    @RequestMapping("/user/getFollowCount")
    public List<Users> getFollowCount(Integer userId){
        return usersService.getFollowCount(userId);
    }
//获取粉丝数
    @RequestMapping("/user/getFanCount")
    public List<Users> getFanCount(Integer userId){
        return usersService.getFanCount(userId);
    }
//获取播放过几首歌
    @RequestMapping("/user/getPlaySongCount")
    public List<Users> getPlaySongCount(Integer userId){
        return usersService.getPlaySongCount(userId);
    }
//获取创建歌单数目
    @RequestMapping("/user/getSongListCreateCount")
    public List<Users> getSongListCreateCount(Integer userId){
        return usersService.getSongListCreateCount(userId);
    }

    //获取收藏歌单数目
    @RequestMapping("/user/getSongListLikedCount")
    public List<Users> getSongListCreateLiked(Integer userId){
        return usersService.getSongListCreateLiked(userId);
    }

    //展示个人听歌排行
    @RequestMapping("/user/getSongRanking")
    public List<Users> getSongRanking(Integer userId){
        return usersService.getSongRanking(userId);
    }

    //展示创建的歌单
    @RequestMapping("/user/getSongListCreate")
    public List<Users> getSongListCreate(Integer userId){
        return usersService.getSongListCreate(userId);
    }

    //展示收藏的歌单
    @RequestMapping("/user/getSongListLiked")
    public List<Users> getSongListLiked(Integer userId){
        List<Users> a =usersService.getSongListLiked(userId);
        return usersService.getSongListLiked(userId);
    }
}
