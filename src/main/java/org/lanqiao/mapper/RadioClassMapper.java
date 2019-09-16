package org.lanqiao.mapper;

import org.lanqiao.entity.RadioClass;

public interface RadioClassMapper {
    int deleteByPrimaryKey(Integer radioClassId);

    int insert(RadioClass record);

    int insertSelective(RadioClass record);

    RadioClass selectByPrimaryKey(Integer radioClassId);

    int updateByPrimaryKeySelective(RadioClass record);

    int updateByPrimaryKey(RadioClass record);
}