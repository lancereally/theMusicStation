package org.lanqiao.service;

import org.lanqiao.entity.Singer;

import java.util.List;

public interface SingerService {

    public List<Singer> getStarByRand();

    public List<Singer> getEnterSinger(Integer size);

    public List<Singer> getHotSigner(Integer size);
    public Singer selectSingerByPk(Integer singerId);

    public Boolean checkUserAndSinger(Integer userId, Integer SingerId);

    //郭长达：通过用户id查询关注的歌手
    public List<Singer> selectByUserId(Integer userId);

    // Lzc : search singer
    public List<Singer> selectSingerByInput(String input);
}
