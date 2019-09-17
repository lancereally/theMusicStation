package org.lanqiao.controller;

import org.lanqiao.entity.SongListComment;
import org.lanqiao.service.SongListCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongListCommentController {
    @Autowired
    SongListCommentService commentService;
    //通过歌单Id查询歌单下所有评论
    @RequestMapping("/MyMusic/songlist/showComment")
    public List<SongListComment> getAllCommentOnSongList(Integer songListId){
        return commentService.selectCommentBySongListId(songListId);
    }
    //添加歌单评论-郭长达
    @RequestMapping("/MyMusic/songlist/insert")
    public int insertSongListComment(SongListComment songListComment){
        return commentService.insertSongListComment(songListComment);
    }
    //查询精彩评论（点赞数大于20）-郭长达
    @RequestMapping("/MyMusic/songlist/awComment")
    public List<SongListComment> getAwComment(Integer songListId){
        return commentService.selectAwesomeComment(songListId);
    }
}
