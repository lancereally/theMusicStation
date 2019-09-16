package org.lanqiao.mapper;

import org.lanqiao.entity.UserSongList;

public interface UserSongListMapper {
    int deleteByPrimaryKey(Integer uslId);

    int insert(UserSongList record);

    int insertSelective(UserSongList record);

    UserSongList selectByPrimaryKey(Integer uslId);

    int updateByPrimaryKeySelective(UserSongList record);

    int updateByPrimaryKey(UserSongList record);
}