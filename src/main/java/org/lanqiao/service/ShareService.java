package org.lanqiao.service;

import org.lanqiao.entity.Share;
import org.lanqiao.entity.ShareComment;

import java.util.List;

public interface ShareService {

    public List<Share> getAllShare();

    public int updateShareLikesByPK(Integer shareId);


//    徐东方
    public List<Share> getEventCount(Integer userId);
//    徐东方

    public int insertShareForward(Share share);

    public List<ShareComment> selectByShareId(Integer shareId);

    public Integer insertShareComment(ShareComment shareComment);



}
