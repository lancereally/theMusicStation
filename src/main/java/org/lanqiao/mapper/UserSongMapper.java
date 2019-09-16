package org.lanqiao.mapper;

import org.lanqiao.entity.UserSong;

public interface UserSongMapper {
    int deleteByPrimaryKey(Integer usId);

    int insert(UserSong record);

    int insertSelective(UserSong record);

    UserSong selectByPrimaryKey(Integer usId);

    int updateByPrimaryKeySelective(UserSong record);

    int updateByPrimaryKey(UserSong record);
}