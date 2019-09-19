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

    //查询单曲
    Song selectSong( Integer songId );
    //查询歌曲信息-郭长达
    Song selectSongInfoBySongId(Integer songId);

    //根据播放次数查询
    List<Song> selectSongByPlayTimes();

    //根据创建时间查询歌单
    List<Song> selectSongByCreateTime();

    //查询原创歌曲
    List<Song> selectTenSong();
}