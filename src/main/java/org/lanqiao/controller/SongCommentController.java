package org.lanqiao.controller;

import org.lanqiao.entity.SongComment;
import org.lanqiao.service.SongCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongCommentController {

    @Autowired
    SongCommentService songCommentService;

    //查询出该歌单下所有的评论-郭长达
    @RequestMapping("/PlayMusic/showComment")
    public List<SongComment> getAllSongCommet(Integer songId) {
        return songCommentService.selectAllComment(songId);
    }

    //添加评论-郭长达
    @RequestMapping("/PlayMusic/insertComment")
    public int insertSongComment(SongComment songComment) {
        return songCommentService.insertSongComment(songComment);
    }
}
