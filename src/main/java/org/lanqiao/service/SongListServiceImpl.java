package org.lanqiao.service;

import org.lanqiao.entity.SongList;
import org.lanqiao.mapper.SongListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongListServiceImpl implements SongListService{

    @Autowired
    SongListMapper songListMapper;
    //查询用户创建的歌单-郭长达
    @Override
    public List<SongList> getLikeSongList(Integer userId) {
        return songListMapper.selectLikeByUserId(userId);
    }
    //查询用户收藏的歌单——郭长达
    @Override
    public List<SongList> getShouSongList(Integer userId) {
        return songListMapper.selectShouByUserId(userId);
    }
    //创建歌单-郭长达
    @Override
    public boolean createSongList(String songListName) {
        return songListMapper.insertSongList(songListName)>0?true:false;
    }
    //返回主键-郭长达
    @Override
    public int selectSongListIdByName(String songListName) {
        return songListMapper.selectSongListBySongListName(songListName);
    }

    //更新歌单用户关系表——郭长达
    @Override
    public int insertUserSongList(Integer songListId,Integer userId,  Integer usRelation) {
        return songListMapper.insertUserSongList(songListId,userId,usRelation);
    }
    //得到歌单信息-郭长达
    @Override
    public SongList getSongListInfo(Integer songListId, Integer userId) {
        return songListMapper.selectBySongListId(songListId,userId);
    }
    //编辑歌单信息-郭长达
    @Override
    public int updateSongListInfo(SongList songList) {
        return songListMapper.updateSongListInfo(songList);
    }
    //删除歌单-郭长达
    @Override
    public int deleteBySongListId(Integer songListId) {
        return songListMapper.deleteByPrimaryKey(songListId);
    }
    //取消收藏歌单——郭长达
    @Override
    public int cancelBySongListId(Integer songListId) {
        return songListMapper.cancelBySongListId(songListId);
    }
    //编辑歌单标签信息-郭长达
    @Override
    public int updataSongListTag(SongList songList) {
        return songListMapper.updataSongListTag(songList);
    }
    //查询拥有某个歌曲的歌单-郭长达
    @Override
    public List<SongList> selectSongListBySongId(Integer songId) {
        return songListMapper.selectSongListBySongId(songId);
    }

    @Override
    public List<SongList> selectByKeyWord(String keyWord) {
        return songListMapper.selectSongList(keyWord);
    }
    // Lzc : search song list
    @Override
    public List<SongList> selectSongListByInput(String input) {
        return songListMapper.selectSongListByInput(input);
    }

    @Override
    public List<SongList> selectEightSongList(){ return songListMapper.selectEightSongList();};
}
