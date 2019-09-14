package org.lanqiao.service;

import org.lanqiao.entity.Song;

import java.util.List;

public interface SongService {
    //查询歌单中的歌曲（通过歌单id？）-郭长达
    List<Song> selectSongBySongListName(Integer songListId);
}
