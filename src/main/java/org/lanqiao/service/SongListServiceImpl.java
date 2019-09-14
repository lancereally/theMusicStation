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


}
