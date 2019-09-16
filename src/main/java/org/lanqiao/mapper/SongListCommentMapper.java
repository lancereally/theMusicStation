package org.lanqiao.mapper;

import org.lanqiao.entity.SongListComment;

public interface SongListCommentMapper {
    int deleteByPrimaryKey(Integer songlcId);

    int insert(SongListComment record);

    int insertSelective(SongListComment record);

    SongListComment selectByPrimaryKey(Integer songlcId);

    int updateByPrimaryKeySelective(SongListComment record);

    int updateByPrimaryKey(SongListComment record);
}