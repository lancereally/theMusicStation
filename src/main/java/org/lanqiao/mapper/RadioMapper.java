package org.lanqiao.mapper;

import org.lanqiao.entity.Radio;

public interface RadioMapper {
    int deleteByPrimaryKey(Integer radioId);

    int insert(Radio record);

    int insertSelective(Radio record);

    Radio selectByPrimaryKey(Integer radioId);

    int updateByPrimaryKeySelective(Radio record);

    int updateByPrimaryKey(Radio record);
}