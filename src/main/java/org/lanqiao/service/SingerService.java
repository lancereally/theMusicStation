package org.lanqiao.service;

import org.lanqiao.entity.Singer;

import java.util.List;

public interface SingerService {

    public List<Singer> getStarByRand();
    //郭长达：通过用户id查询关注的歌手
    public List<Singer> selectByUserId(Integer userId);

    // Lzc : search singer
    public List<Singer> selectSingerByInput(String input);
}
