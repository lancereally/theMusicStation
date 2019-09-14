package org.lanqiao.service;

import org.lanqiao.entity.Singer;

import java.util.List;

public interface SingerService {

    public List<Singer> getStarByRand();

    public List<Singer> getEnterSinger(Integer size, Integer check);

}
