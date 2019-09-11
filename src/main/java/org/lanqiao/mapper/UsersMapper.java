package org.lanqiao.mapper;

import org.lanqiao.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

//    徐东方



//
}