package org.lanqiao.service;

import org.lanqiao.entity.SongComment;

import java.util.List;

public interface SongCommentService {
    //查询出该歌单下所有的评论-郭长达
    List<SongComment> selectAllComment(Integer songId);
    //添加评论-郭长达
    int insertSongComment(SongComment songComment);
}
