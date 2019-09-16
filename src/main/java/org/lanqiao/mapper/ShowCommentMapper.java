package org.lanqiao.mapper;

import org.lanqiao.entity.ShowComment;

public interface ShowCommentMapper {
    int deleteByPrimaryKey(Integer showcId);

    int insert(ShowComment record);

    int insertSelective(ShowComment record);

    ShowComment selectByPrimaryKey(Integer showcId);

    int updateByPrimaryKeySelective(ShowComment record);

    int updateByPrimaryKey(ShowComment record);
}