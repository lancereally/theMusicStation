package org.lanqiao.service;

import org.lanqiao.entity.Users;

import java.util.List;

public interface UsersService {

    //》》》郭书卿》》》
    public Users getShareUser_q(Integer userId);

    public List<Users> getOtherUsersByRand();

    public Integer becomeOtherFan(Integer userId,Integer otherId);
    //《《《郭书卿《《《
    //郭长达-查询用户头像
    public Users getUserHeadPic(Integer userId);
    //获取喜欢这首歌的用户头像
    public List<Users> getUserHeadPicLikeSong(Integer songId);
}
