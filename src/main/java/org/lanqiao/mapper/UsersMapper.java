package org.lanqiao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.lanqiao.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);


    //》》》郭书卿》》》
    Users selectShareCountByPK_q(Integer userId);
    Users selectFansByPk_q(Integer userId);
    Users selectAttentionByPK_q(Integer userId);
    List<Users> selectOtherUsersByRand();
    Integer insertFan(Integer userId, Integer otherId);
    Users checkFan(Integer userId, Integer otherId);
    //《《《郭书卿《《《



//    徐东方
    Users getLittleInfo(Integer userId);

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

    public int checkName(String userName);

    //注册


    //账号登录
    public int accountLogin(Users users);

    //获取comment
    public List<Users> getMyComment(Users users);

    //拉取fans and follows
    public List<Users> getMyFollows(Users users);

    public List<Users> getMyFans(Users users);

    //cookie
    public int getIdByAnything(Users users);

    //手机
    public int updatePhoneInfo(Users users);
    public int selectCodeByPhone(String phoneNumber);
    public String getUserPhone(Integer userId);
    public List<Users> checkPhone(String phoneNumber);
// 徐东方
}