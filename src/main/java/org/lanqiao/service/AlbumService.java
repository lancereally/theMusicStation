package org.lanqiao.service;

import org.lanqiao.entity.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> selectBySingerId(Integer singerId);
    // Lzc - search
    public List<Album> selectAlbumByInput(String input);
    public List<Album> select15Album();
}