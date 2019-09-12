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
    public Users getShareUser_q(Integer userId) {
        Users users = new Users();
        users = usersMapper.selectByPrimaryKey(userId);
        users.setShareCount(usersMapper.selectShareCountByPK_q(userId).getShareCount());
        users.setAttention(usersMapper.selectAttentionByPK_q(userId).getAttention());
        users.setFans(usersMapper.selectFansByPk_q(userId).getFans());
        return users;
    }

    @Override
    public List<Users> getOtherUsersByRand() {
        return usersMapper.selectOtherUsersByRand();
    }
}
