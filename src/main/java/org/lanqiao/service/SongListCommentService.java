package org.lanqiao.service;

import org.lanqiao.entity.SongListComment;

import java.util.List;

public interface SongListCommentService {
    //查询歌单下所有评论bySongListId-gcd
    List<SongListComment> selectCommentBySongListId(Integer songListId);
    //添加评论-郭长达
    int insertSongListComment(SongListComment songListComment);
    //查询精彩评论-郭长达
    List<SongListComment> selectAwesomeComment(Integer songListId);
    //点赞-郭长达
    int updateCommentLike(Integer songlcId);
}
