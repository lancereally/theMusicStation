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

    //郭长达
    //查询用户头像
    Users selectHeadUrl(Integer userId);
    //》》》郭书卿》》》
    Users selectShareCountByPK_q(Integer userId);
    Users selectFansByPk_q(Integer userId);
    Users selectAttentionByPK_q(Integer userId);
    List<Users> selectOtherUsersByRand();
    Integer insertFan(Integer userId, Integer otherId);
    Users checkFan(Integer userId, Integer otherId);
    //《《《郭书卿《《《


//    徐东方



//
}