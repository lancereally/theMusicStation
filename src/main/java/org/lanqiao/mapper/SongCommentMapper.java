package org.lanqiao.mapper;

import org.lanqiao.entity.SongComment;

public interface SongCommentMapper {
    int deleteByPrimaryKey(Integer songcId);

    int insert(SongComment record);

    int insertSelective(SongComment record);

    SongComment selectByPrimaryKey(Integer songcId);

    int updateByPrimaryKeySelective(SongComment record);

    int updateByPrimaryKey(SongComment record);
}