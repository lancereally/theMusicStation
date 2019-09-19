package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lanqiao.entity.Song;
import org.lanqiao.entity.SongList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SongListMapper {

    int insert(SongList record);

    int insertSelective(SongList record);

    SongList selectByPrimaryKey(Integer songlistId);

    int updateByPrimaryKeySelective(SongList record);

    int updateByPrimaryKey(SongList record);
    //查询歌单的信息-郭长达
    SongList selectBySongListId(@Param("songListId") Integer songListId,@Param("userId")Integer userId);
    //查询创建的歌单-郭长达
    List<SongList> selectLikeByUserId(Integer userId);
    //查询收藏的歌单-郭长达
    List<SongList> selectShouByUserId(Integer userId);
    //创建歌单-郭长达
    int insertSongList(String songListName);
    //查询歌单的id-郭长达
    int selectSongListBySongListName(String songListName);
    //更新歌单用户关系表——郭长达
    int insertUserSongList(@Param("songListId") Integer songListId,@Param("userId") Integer userId,@Param("usRelation") Integer usRelation);
    //编辑歌单信息-郭长达
    int updateSongListInfo(SongList songList);
    //删除歌单-gcd
    int deleteByPrimaryKey(Integer songlistId);
    //取消收藏歌单-郭长达
    int cancelBySongListId(Integer songlistId);
    //编辑歌单标签-郭长达
    int updataSongListTag(SongList songList);
    //查询拥有某个歌曲的歌单-郭长达
    List<SongList> selectSongListBySongId(Integer songId);
    List<SongList> selectSongList(String keyWord);
    // Lzc : search song list
    List<SongList> selectSongListByInput(String input);
}