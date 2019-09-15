package org.lanqiao.service;

import org.lanqiao.entity.Album;

import java.util.List;

public interface AlbumService {
    // Lzc - search
    public List<Album> selectAlbumByInput(String input);
}
