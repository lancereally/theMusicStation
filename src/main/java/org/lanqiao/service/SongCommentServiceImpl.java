package org.lanqiao.service;

import org.lanqiao.entity.SongComment;
import org.lanqiao.mapper.SongCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongCommentServiceImpl implements SongCommentService {

    @Autowired
    SongCommentMapper songCommentMapper;

    //查询出该歌曲下所有的评论-郭长达
    @Override
    public List<SongComment> selectAllComment(Integer songId) {
        return songCommentMapper.selectCommentBySongId(songId);
    }
    //添加评论-郭长达
    @Override
    public int insertSongComment(SongComment songComment) {
        return songCommentMapper.insertSongComment(songComment);
    }
    //精彩评论查询-郭长达
    @Override
    public List<SongComment> selectAwComment(Integer songId) {
        return songCommentMapper.selectAwesomeComment(songId);
    }
    //查询出该歌曲下精彩评论-郭长达
    @Override
    public int updateSongCommentLike(Integer songcId) {
        return songCommentMapper.updateLikeNum(songcId);
    }
}
