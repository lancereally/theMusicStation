package org.lanqiao.controller;

import org.lanqiao.entity.SongComment;
import org.lanqiao.entity.Users;
import org.lanqiao.service.SongCommentService;
import org.lanqiao.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongCommentController {

    @Autowired
    SongCommentService songCommentService;
    @Autowired
    UsersService usersService;

    //查询出该歌曲下所有的评论-郭长达
    @RequestMapping("/PlayMusic/showComment")
    public List<SongComment> getAllSongCommet(Integer songId) {
        return songCommentService.selectAllComment(songId);
    }

    //添加评论-郭长达
    @RequestMapping("/PlayMusic/insertComment")
    public int insertSongComment(SongComment songComment) {
        return songCommentService.insertSongComment(songComment);
    }

    //精彩评论查询-郭长达
    @RequestMapping("/PlayMusic/showAwComment")
    public List<SongComment> getAwesomeComment(Integer songId){
        return songCommentService.selectAwComment(songId);
    }

    //查询出该歌曲下精彩评论-郭长达
    @RequestMapping("/PlayMusic/addCommentLike")
    public int updateSongCommentLike(Integer songcId){
        return songCommentService.updateSongCommentLike(songcId);
    }
    //郭长达-查询用户头像
    @RequestMapping("/PlayMusic/showUserHead")
    public Users getUserHeadPic(Integer userId){
        return usersService.getUserHeadPic(userId);
    }
}
