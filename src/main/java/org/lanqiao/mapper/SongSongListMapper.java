package org.lanqiao.mapper;

import org.lanqiao.entity.SongSongList;

public interface SongSongListMapper {
    int insert(SongSongList record);

    int insertSelective(SongSongList record);
}