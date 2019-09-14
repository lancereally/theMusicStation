package org.lanqiao.service;

import org.lanqiao.entity.Share;
import org.lanqiao.entity.ShareComment;

import java.util.List;

public interface ShareService {

    public List<Share> getAllShare();

    public int updateShareLikesByPK(Integer shareId);

    public int insertShareForward(Share share);

    public List<ShareComment> selectByShareId(Integer shareId);

    public Integer insertShareComment(ShareComment shareComment);


}
