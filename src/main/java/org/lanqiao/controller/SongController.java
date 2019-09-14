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
}
