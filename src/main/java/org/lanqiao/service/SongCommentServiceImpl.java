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
        List<SongComment> AllCommentlist = songCommentMapper.selectCommentBySongId(songId);
        for (SongComment item:AllCommentlist) {
            item.setToUserName(songCommentMapper.selectUserNameById(item.getSongcToId()));
        }
        return AllCommentlist;
    }
    //添加评论-郭长达
    @Override
    public int insertSongComment(SongComment songComment) {
        return songCommentMapper.insertSongComment(songComment);
    }
    //精彩评论查询-郭长达
    @Override
    public List<SongComment> selectAwComment(Integer songId) {
        List<SongComment> awlist = songCommentMapper.selectAwesomeComment(songId);
        for (SongComment sc :awlist) {
            sc.setToUserName(songCommentMapper.selectUserNameById(sc.getSongcToId()));
        }
        return awlist;
    }
    //查询出该歌曲下精彩评论-郭长达
    @Override
    public int updateSongCommentLike(Integer songcId) {
        return songCommentMapper.updateLikeNum(songcId);
    }
}
