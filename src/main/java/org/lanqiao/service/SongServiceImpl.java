package org.lanqiao.service;

import org.lanqiao.entity.Song;
import org.lanqiao.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService{
    @Autowired
    SongMapper songMapper;

    @Override
    public List<Song> selectSongBySongListName(Integer songListId) {
        return songMapper.selectSongBySongList(songListId);
    }

    @Override
    public int selectSongCount(Integer songListId) {
//        List<Integer> list = null;
//        int count=0;
//        list.add(songMapper.selectSongBySongList(songListId).size());
//        for (Song s: songMapper.selectSongBySongList(songListId)) {
//           count= count+ s.getSongPlayTimes();
//        }
//        list.add(count);

        return songMapper.selectSongBySongList(songListId).size();
    }

    @Override
    public int selectSongPlayCount(Integer songListId) {
        int count = 0;
        for (Song s : songMapper.selectSongBySongList(songListId)) {
            count += s.getSongPlayTimes();
        }
        return count;
    }

    @Override
    public Song selectSongInfoBySongId(Integer songId) {
        return songMapper.selectSongInfoBySongId(songId);
    }
}
