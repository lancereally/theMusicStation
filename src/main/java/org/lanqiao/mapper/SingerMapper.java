package org.lanqiao.mapper;

import org.lanqiao.entity.Singer;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerMapper {
    int deleteByPrimaryKey(Integer singerId);

    int insert(Singer record);

    int insertSelective(Singer record);

    Singer selectByPrimaryKey(Integer singerId);

    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKey(Singer record);

}