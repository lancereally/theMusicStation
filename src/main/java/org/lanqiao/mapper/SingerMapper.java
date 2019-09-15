package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.Singer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SingerMapper {
    int deleteByPrimaryKey(Integer singerId);

    int insert(Singer record);

    int insertSelective(Singer record);

    Singer selectByPrimaryKey(Integer singerId);

    int updateByPrimaryKeySelective(Singer record);

    int updateByPrimaryKey(Singer record);

    //》》》郭书卿》》》
    List<Singer> selectStarByRand();
    List<Singer> selectEnterSingers(Integer size);
    List<Singer> selectHotSingers(Integer size);
    List<Singer> selectSingerByKeyWord(String keyWord);
    //《《《郭书卿《《《

}