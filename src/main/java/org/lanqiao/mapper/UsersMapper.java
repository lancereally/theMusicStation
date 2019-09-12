package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);


//    徐东方
    Users getLittleInfo(Integer userId);

    public List<Users> getFollowCount(Integer userId);

    public List<Users> getFanCount(Integer userId);

    public List<Users> getPlaySongCount(Integer userId);

    public List<Users> getSongListCreateCount(Integer userId);

    public List<Users> getSongListCreateLiked(Integer userId);

    public List<Users> getSongRanking(Integer userId);

    //展示创建的歌单
    public List<Users> getSongListCreate(Integer userId);

    //展示收藏的歌单
    public List<Users> getSongListLiked(Integer userId);

// 徐东方
}