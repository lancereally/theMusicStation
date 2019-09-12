package org.lanqiao.service;

import org.lanqiao.entity.Users;

import java.util.List;

public interface UsersService {

    //》》》郭书卿》》》
    public Users getShareUser_q(Integer userId);

    public List<Users> getOtherUsersByRand();
    //《《《郭书卿《《《

}
