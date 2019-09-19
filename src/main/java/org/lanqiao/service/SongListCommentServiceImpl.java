package org.lanqiao.service;


import org.lanqiao.entity.SongListComment;
import org.lanqiao.mapper.SongListCommentMapper;
import org.lanqiao.mapper.SongListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongListCommentServiceImpl implements SongListCommentService {

    @Autowired
    SongListCommentMapper songListCommentMapper;
    @Override
    public List<SongListComment> selectCommentBySongListId(Integer songListId) {
        List<SongListComment> list = songListCommentMapper.selectCommentBySongListId(songListId);
        for (SongListComment item : list) {
            item.setToUserName(songListCommentMapper.selectUserNameById(item.getSonglcToId()));
        }
        return list;
    }

    @Override
    public int insertSongListComment(SongListComment songListComment) {
        return songListCommentMapper.insertSongListComment(songListComment);
    }
    //查询精彩评论-郭长达
    @Override
    public List<SongListComment> selectAwesomeComment(Integer songListId) {
        List<SongListComment> listComments = songListCommentMapper.selectAwesomeComment(songListId);
        for (SongListComment item : listComments) {
            item.setToUserName(songListCommentMapper.selectUserNameById(item.getSonglcToId()));
        }
        return listComments;
    }
    //歌单点赞-郭长达
    @Override
    public int updateCommentLike(Integer songlcId) {
        return songListCommentMapper.updateLikeNum(songlcId);
    }
}
