package org.lanqiao.mapper;

import org.lanqiao.entity.SongList;

public interface SongListMapper {
    int deleteByPrimaryKey(Integer songlistId);

    int insert(SongList record);

    int insertSelective(SongList record);

    SongList selectByPrimaryKey(Integer songlistId);

    int updateByPrimaryKeySelective(SongList record);

    int updateByPrimaryKey(SongList record);
}