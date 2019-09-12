package org.lanqiao.service;

import org.lanqiao.entity.Users;

import java.util.List;

public interface UsersService {

    public Users getLittleInfo (Integer userId);

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
}
