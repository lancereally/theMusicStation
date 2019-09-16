package org.lanqiao.service;


import org.lanqiao.entity.SongListComment;
import org.lanqiao.mapper.SongListCommentMapper;
import org.lanqiao.mapper.SongListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongListCommetServiceImpl implements SongListCommentService {

    @Autowired
    SongListCommentMapper songListCommentMapper;
    @Override
    public List<SongListComment> selectCommentBySongListId(Integer songListId) {
        return songListCommentMapper.selectCommentBySongListId(songListId);
    }

    @Override
    public int insertSongListComment(SongListComment songListComment) {
        return songListCommentMapper.insertSongListComment(songListComment);
    }
}
