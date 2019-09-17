package org.lanqiao.controller;

import org.lanqiao.entity.Singer;
import org.lanqiao.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SingerController {
    @Autowired
    SingerService singerService;
    //郭长达：我的音乐的我的歌手栏
    @RequestMapping("/MyMusic/mysinger")
    public List<Singer> getSingerListOnMyMusic(Integer userId){
        return singerService.selectByUserId(userId);
    }

    @RequestMapping("/singer/checkCollection")
    public String checkUserAndSinger(Integer userId, Integer singerId){
        return singerService.checkUserAndSinger(userId,singerId) + "";
    }

    @RequestMapping("/singer/collectionSinger")
    public int insertSingerAndUser(Integer userId, Integer singerId){
        return singerService.insertSingerAndUser(userId,singerId);
    }
}
