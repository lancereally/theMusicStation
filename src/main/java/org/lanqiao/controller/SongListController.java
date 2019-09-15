package org.lanqiao.controller;

import org.lanqiao.entity.SongList;
import org.lanqiao.entity.SongListUserVo;
import org.lanqiao.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongListController {
    @Autowired
    SongListService songListService;
    //通过用户id查询创建歌单——郭长达
    @RequestMapping("/MyMusic/likesonglist")
    public List<SongList> getLikeSongListByUserId(Integer userId){
        return songListService.getLikeSongList(userId);
    }
    //查询用户收藏的歌单——郭长达
    @RequestMapping("/MyMusic/shousonglist")
    public List<SongList> getShouSongListByUserId(Integer userId){
        return songListService.getShouSongList(userId);
    }
    //创建新歌单——郭长达
    @RequestMapping("/MyMusic/createSonglist")
    public boolean createSongList(String songListName){
        return songListService.createSongList(songListName);
    }
    //查询歌单id——郭长达
    @RequestMapping("/MyMusic/selectId")
    public  int selectSongListId(String songListName){
        return songListService.selectSongListIdByName(songListName);
    }
    //更新歌单用户关系表——郭长达
    @RequestMapping("/MyMusic/insertRelation")
    public int insertUserSongList(int songListId,int userId,int usRelation){
        return songListService.insertUserSongList(songListId,userId,usRelation);
    }
    //查询某个歌单信息
    @RequestMapping("/MyMusic/showSonglistInfo")
    public SongList getSongListInfo(Integer songListId,Integer userId){
        return songListService.getSongListInfo(songListId,userId);
    }
    //编辑歌单信息
    @RequestMapping("/MyMusic/editSonglist")
    public int editSongListInfo(SongList songList){
        return songListService.updateSongListInfo(songList);
    }
}
