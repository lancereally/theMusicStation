package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.Share;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShareMapper {
    int deleteByPrimaryKey(Integer shareId);

    int insert(Share record);

    int insertSelective(Share record);

    Share selectByPrimaryKey(Integer shareId);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);

    List<Share> getAllShare_q();

    Share getShareForwardCount_q(Integer shareId);

    Share getShareCommentCount_q(Integer shareId);

    Share selectShareByPK_q(Integer shareId);

//    Share getSongAndSinger(Integer shareId);

}