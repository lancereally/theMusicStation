package org.lanqiao.service;

import org.lanqiao.entity.Users;
import org.lanqiao.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public Integer becomeOtherFan(Integer userId, Integer otherId) {
        if (usersMapper.checkFan(userId,otherId).getFans() > 0){
            return null;
        }else {
            return usersMapper.insertFan(userId,otherId);
        }
    }

    @Override
    public List<Users> selectUsersByInput(String input) {
         return usersMapper.selectUsersByInput(input);
         // better but not access yet
//        List<Integer> userIdList = new ArrayList<>();
//        List<Users> usersList = usersMapper.selectUsersByInput1(input);
//        for (Users user : usersList) {
//            userIdList.add(user.getUserId());
//        }
//        int i = 0;
//        for (Users user : usersList) {
//            user.setSongListCount(usersMapper.selectUsersByInput2(userIdList).get(i++));
//        }
//        i = 0;
//        for (Users user : usersList) {
//            user.setFans(usersMapper.selectUsersByInput3(userIdList).get(i++));
//        }
//        return usersList;
    }
}
