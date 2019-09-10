package org.lanqiao.service;

import org.lanqiao.entity.Share;

import java.util.List;

public interface ShareService {

    public List<Share> getAllShare();

    public int updateShareLikesByPK(Integer shareId);


}
