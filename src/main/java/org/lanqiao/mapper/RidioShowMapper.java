package org.lanqiao.mapper;

import org.lanqiao.entity.RidioShow;

public interface RidioShowMapper {
    int deleteByPrimaryKey(Integer showId);

    int insert(RidioShow record);

    int insertSelective(RidioShow record);

    RidioShow selectByPrimaryKey(Integer showId);

    int updateByPrimaryKeySelective(RidioShow record);

    int updateByPrimaryKey(RidioShow record);
}