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
        return usersMapper.selectByPrimaryKey(userId);
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

    //更新用户基本设置信息
    @Override
    public int updateUserInfo(Users users){
        return usersMapper.updateUserInfo(users) ;
    }

    @Override
    public boolean checkName(String userName){
        return usersMapper.checkName(userName) < 1 ? true : false;
    }

    //注册
    @Override
    public int register(Users users){
        return usersMapper.insertSelective(users);
    }

    //账号登录
    @Override
    public boolean accountLogin(Users users){
        return usersMapper.accountLogin(users) < 0 ? true : false;
    }

    //VIP
    @Override
    public boolean activeVIP(Users users){
        return usersMapper.updateVIP(users) > 0 ? true : false;
    }

    //获取评论
    @Override
    public List<Users> getMyComment(Users users){
        return usersMapper.getMyComment(users);
    }

    //获取通知
    @Override
    public List<Users> getMyNotice(Users users){
        return usersMapper.getMyNotice(users);
    }

    //拉取fans and follows
    @Override
    public List<Users> getMyFollows(Users users){
        return usersMapper.getMyFollows(users);
    }

    @Override
    public List<Users> getMyFans(Users users){
        return usersMapper.getMyFans(users);
    }

    //cookie
    @Override
    public int getIdByAnything(Users users){
        return usersMapper.getIdByAnything(users);
    }

    //手机
    @Override
    public void updatePhoneInfo(Users users){
        usersMapper.updatePhoneInfo(users);
    }

    @Override
    public int selectCodeByPhone(String phoneNumber){
        return usersMapper.selectCodeByPhone(phoneNumber);
    }

    @Override
    public String getUserPhone(Integer userId)  {
        return usersMapper.getUserPhone(userId);
    }

    @Override
    public List<Users> checkPhone(String phoneNumber) {
        return usersMapper.checkPhone(phoneNumber);
    }
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
    //郭长达-查询用户头像
    @Override
    public Users getUserHeadPic(Integer userId) {
        return usersMapper.selectHeadUrl(userId);
    }
}
