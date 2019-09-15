package org.lanqiao.service;

import org.lanqiao.entity.Album;

import java.util.List;

public interface AlbumService {
    public List<Album> seelctBySingerId(Integer singerId);
}
