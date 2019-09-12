package org.lanqiao.service;

import org.lanqiao.entity.Users;
import org.lanqiao.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Users getLittleInfo (Integer userId){
        return usersMapper.getLittleInfo(userId);
    }

    @Override
    public List<Users> getFollowCount(Integer userId){
        return usersMapper.getFollowCount(userId);
    }

    @Override
    public List<Users> getFanCount(Integer userId){
        return usersMapper.getFanCount(userId);
    }

    @Override
    public List<Users> getPlaySongCount(Integer userId){
        return usersMapper.getPlaySongCount(userId);
    }

    @Override
    public List<Users> getSongListCreateCount(Integer userId){
        return usersMapper.getSongListCreateCount(userId);
    }

    //获取收藏歌单数目
    @Override
    public List<Users> getSongListCreateLiked(Integer userId){
        return usersMapper.getSongListCreateLiked(userId);
    }

    //展示个人听歌排行
    @Override
    public List<Users> getSongRanking(Integer userId){
        return usersMapper.getSongRanking(userId);
    }

    //展示创建的歌单
    @Override
    public List<Users> getSongListCreate(Integer userId){
        return usersMapper.getSongListCreate(userId);
    }

    //展示收藏的歌单
    @Override
    public List<Users> getSongListLiked(Integer userId){
        return usersMapper.getSongListLiked(userId);
    }
}
