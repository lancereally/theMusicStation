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

    public int updateUserInfo(Users users);

    public boolean checkName(String userName);

    //注册
    public int register(Users users);

    //账号登录
    public boolean accountLogin(Users users);


    //VIP
    public boolean activeVIP(Users users);

    //获取comment
    public List<Users> getMyComment(Users users);

    //拉取fans and follows
    public List<Users> getMyFollows(Users users);

    public List<Users> getMyFans(Users users);

    //cookie
    public int getIdByAnything(Users users);

    //手机
    public void updatePhoneInfo(Users users);
    public int selectCodeByPhone(String phoneNumber);
    public String getUserPhone(Integer userId);
    public List<Users> checkPhone(String phoneNumber);
}
