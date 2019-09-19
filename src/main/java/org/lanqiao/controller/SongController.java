package org.lanqiao.controller;

import org.lanqiao.entity.Song;
import org.lanqiao.entity.Users;
import org.lanqiao.service.SongService;
import org.lanqiao.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {
    @Autowired
    SongService songService;
    @Autowired
    UsersService usersService;
    //展示歌单歌曲-郭长达
    @RequestMapping("/MyMusic/songlist/songshow")
    public List<Song> getSongBySongListName(Integer songListId){
        return songService.selectSongBySongListName(songListId);
    }
    //查询歌单歌曲总数
    @RequestMapping("/MyMusic/songlist/countshow")
    public int getSongCountInfo(Integer songListId){
        return songService.selectSongCount(songListId);
    }
    //查询歌单歌曲播放总数
    @RequestMapping("/MyMusic/songlist/playcountshow")
    public int getSongPlayCount(Integer songListId){
        return songService.selectSongPlayCount(songListId);
    }

    //查询单曲
    @RequestMapping("/MyMusic/songlist/songselect")
    public Song selectSong(Integer songId) {
        return songService.selectSong(songId);
    }


    //查询歌曲信息-郭长达
    @RequestMapping("/MyMusic/songInfo/show")
    public Song getSongInfoBySongId(Integer songId){
        return songService.selectSongInfoBySongId(songId);
    }

    //获取喜欢这首歌的用户头像
    @RequestMapping("/PlayMusic/likeSong/userShow")
    public List<Users> getUserHeadLikeSong(Integer songId){
        return usersService.getUserHeadPicLikeSong(songId);
    }
    // Lzc : search lyric
    @RequestMapping("/search/selectLyricByInput")
    public List<Song> selectLyricByInput(String input){
        return songService.selectLyricByInput(input);
    }

    //根据播放次数查询
    @RequestMapping("Index/playTime/selectSongByPlayTimes")
    public List<Song> selectSongByPlayTimes(){return songService.selectSongByPlayTimes();}
    //根据创建时间查询
    @RequestMapping("Index/CreateTime/selectSongByCreateTime")
    public List<Song> selectSongByCreateTime(){return songService.selectSongByCreateTime();}
    //查询原创歌曲
    @RequestMapping("Index/tenSong/selectTenSong")
    public List<Song> selectTenSong(){
        return songService.selectTenSong();
    }
}
