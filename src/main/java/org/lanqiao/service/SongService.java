package org.lanqiao.service;

import org.lanqiao.entity.Song;

import java.util.List;

public interface SongService {
    //查询歌单中的歌曲（通过歌单id？）-郭长达
    List<Song> selectSongBySongListName(Integer songListId);
    //查询歌单歌曲总数和播放总数
    int selectSongCount(Integer songListId);
    int selectSongPlayCount(Integer songListId);

    //根据id查询单曲
    Song selectSong( Integer songId );
    //查询歌曲信息-郭长达
    Song selectSongInfoBySongId(Integer songId);
    // Lzc : search lyric
    List<Song> selectLyricByInput(String input);

    //根据播放次数查询
    List<Song> selectSongByPlayTimes();
    //根据创建时间查询
    List<Song> selectSongByCreateTime();

    //查询原创歌曲
    List<Song> selectTenSong();
}
