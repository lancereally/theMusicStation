package org.lanqiao.service;

import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.SongList;

import java.util.List;

public interface SongListService {
    //查询用户创建的歌单——郭长达
    List<SongList> getLikeSongList(Integer userId);
    //查询用户收藏的歌单——郭长达
    List<SongList> getShouSongList(Integer userId);
    //创建歌单-郭长达
    boolean createSongList(String songListName);
    //查询歌单id-郭长达
    int selectSongListIdByName(String songListName);
    //更新歌单用户关系表——郭长达
    int insertUserSongList(Integer songListId,Integer userId,Integer usRelation);
    //查询歌单信息-郭长达
    SongList getSongListInfo(Integer songListId,Integer userId);
    //编辑歌单信息-郭长达
    int updateSongListInfo(SongList songList);
}
