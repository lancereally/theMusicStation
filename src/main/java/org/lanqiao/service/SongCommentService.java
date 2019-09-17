package org.lanqiao.service;

import org.lanqiao.entity.SongComment;

import java.util.List;

public interface SongCommentService {
    //查询出该歌曲下所有的评论-郭长达
    List<SongComment> selectAllComment(Integer songId);
    //添加评论-郭长达
    int insertSongComment(SongComment songComment);
    //精彩评论查询-郭长达
    List<SongComment> selectAwComment(Integer songId);
    //歌曲点赞-郭长达
    int updateSongCommentLike(Integer songcId);
}
