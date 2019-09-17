package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.SongComment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface SongCommentMapper {
    int deleteByPrimaryKey(Integer songcId);

    int insert(SongComment record);

    int insertSelective(SongComment record);

    SongComment selectByPrimaryKey(Integer songcId);

    int updateByPrimaryKeySelective(SongComment record);

    int updateByPrimaryKey(SongComment record);
    //查询出该歌曲下所有的评论-郭长达
    List<SongComment> selectCommentBySongId(Integer songId);
    //添加评论-郭长达
    int insertSongComment(SongComment songComment);
    //精彩评论查询-郭长达
    List<SongComment> selectAwesomeComment(Integer songId);
    //歌曲点赞-郭长达
    int updateLikeNum(Integer songId);
}