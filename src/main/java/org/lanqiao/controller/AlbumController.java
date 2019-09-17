package org.lanqiao.controller;

import org.lanqiao.entity.Album;
import org.lanqiao.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {
    @Autowired
    AlbumService albumService;

    // Lzc - search album
    @RequestMapping("/search/selectAlbumByInput")
    public List<Album> selectAlbumByInput(String input){
        return albumService.selectAlbumByInput(input);
    }

}
