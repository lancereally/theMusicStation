package org.lanqiao.service;

import org.lanqiao.entity.Song;
import org.lanqiao.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    SongMapper songMapper;

    @Override
    public List<Song> selectSongBySongListName(Integer songListId) {
        return songMapper.selectSongBySongList(songListId);
    }
}
