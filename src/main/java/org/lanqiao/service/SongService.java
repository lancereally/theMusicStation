package org.lanqiao.service;

import org.lanqiao.entity.Song;

import java.util.List;

public interface SongService {
    //查询歌单中的歌曲（通过歌单id？）-郭长达
    List<Song> selectSongBySongListName(Integer songListId);
    //查询歌单歌曲总数和播放总数
    int selectSongCount(Integer songListId);
    int selectSongPlayCount(Integer songListId);
    //查询歌曲信息-郭长达
    Song selectSongInfoBySongId(Integer songId);
}
