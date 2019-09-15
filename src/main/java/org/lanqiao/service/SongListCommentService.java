package org.lanqiao.service;

import org.lanqiao.entity.SongListComment;

import java.util.List;

public interface SongListCommentService {
    //查询歌单下所有评论bySongListId-gcd
    List<SongListComment> selectCommentBySongListId(Integer songListId);
}
