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
        return singerMapper.selectStarByRand();
    }
    //郭长达：通过用户id查询关注的歌手
    @Override
    public List<Singer> selectByUserId(Integer userId) {
        List<Singer> singerList =singerMapper.selectByUserId(userId);

        return singerList;
    }

    @Override
    public List<Singer> getEnterSinger(Integer size) {
        return singerMapper.selectEnterSingers(size);
    }

    @Override
    public List<Singer> getHotSigner(Integer size) {
        return singerMapper.selectHotSingers(size);
    }

    @Override
    public Singer selectSingerByPk(Integer singerId) {
        return singerMapper.selectByPrimaryKey(singerId);
    }


    @Override
    public Boolean checkUserAndSinger(Integer userId, Integer singerId) {
        return singerMapper.selectSingerAndUser(userId,singerId).getUserId() > 0 ? true : false;
    }

    @Override
    public int insertSingerAndUser(Integer userId, Integer SingerId) {
        return singerMapper.insertSingerAndUser(userId,SingerId);
    }
}
