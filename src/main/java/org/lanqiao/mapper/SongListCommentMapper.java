package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.SongListComment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SongListCommentMapper {
    int deleteByPrimaryKey(Integer songlcId);

    int insert(SongListComment record);

    int insertSelective(SongListComment record);

    SongListComment selectByPrimaryKey(Integer songlcId);

    int updateByPrimaryKeySelective(SongListComment record);

    int updateByPrimaryKey(SongListComment record);
    //查询出该歌单下所有的评论-郭长达
    List<SongListComment> selectCommentBySongListId(Integer songListId);
}