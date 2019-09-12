package org.lanqiao.service;

import org.lanqiao.entity.Singer;
import org.lanqiao.mapper.SingerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    SingerMapper singerMapper;

    @Override
    public List<Singer> getStarByRand() {
        List<Singer> singerList = singerMapper.selectStarByRand();
        return singerList;
    }

}