package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.Song;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SongMapper {
    int deleteByPrimaryKey(Integer songId);

    int insert(Song record);

    int insertSelective(Song record);

    Song selectByPrimaryKey(Integer songId);

    int updateByPrimaryKeySelective(Song record);

    int updateByPrimaryKey(Song record);

    Song selectSingerByPK_q(Integer songId);
    //查询歌单的歌曲-郭长达
    List<Song> selectSongBySongList(Integer songListId);
    //查询歌单中歌曲数和播放次数
//    int selectSongPlayCount(Integer songListId);
//    int selectSongCount(Integer songListId);
    // Lzc : search lyric
    List<Song> selectLyricByInput(String input);
}