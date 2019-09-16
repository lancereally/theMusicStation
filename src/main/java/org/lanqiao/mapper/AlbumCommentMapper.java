package org.lanqiao.mapper;

import org.lanqiao.entity.AlbumComment;

public interface AlbumCommentMapper {
    int deleteByPrimaryKey(Integer albumcId);

    int insert(AlbumComment record);

    int insertSelective(AlbumComment record);

    AlbumComment selectByPrimaryKey(Integer albumcId);

    int updateByPrimaryKeySelective(AlbumComment record);

    int updateByPrimaryKey(AlbumComment record);
}