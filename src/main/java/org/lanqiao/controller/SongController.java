package org.lanqiao.controller;

import org.lanqiao.entity.Song;
import org.lanqiao.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {
    @Autowired
    SongService songService;
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
}
