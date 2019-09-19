package org.lanqiao.service;

import org.lanqiao.entity.Share;
import org.lanqiao.entity.ShareComment;
import org.lanqiao.entity.Song;
import org.lanqiao.mapper.ShareCommentMapper;
import org.lanqiao.mapper.ShareMapper;
import org.lanqiao.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class ShareServiceImpl implements ShareService{

    @Autowired
    ShareMapper shareMapper;

    @Autowired
    SongMapper songMapper;

    @Autowired
    ShareCommentMapper shareCommentMapper;

    @Override
    public int insertShareForward(Share share) {
        return shareMapper.insertSelective(share);
    }

    @Override
    public List<Share> getAllShare() {
        List<Share> shareList = shareMapper.getAllShare_q();
        for (Share s: shareList) {
            s.setShareCommentCount(shareMapper.getShareCommentCount_q(s.getShareId()).getShareCommentCount());
            s.setShareForwardCount(shareMapper.getShareForwardCount_q(s.getShareId()).getShareForwardCount());
            if (s.getSongId() != null){
                Song song = songMapper.selectSingerByPK_q(s.getSongId());
                s.setSongName(song.getSongName());
                s.setSongUrl(song.getSongUrl());
                s.setSongPicUrl(song.getSongPicUrl());
                s.setSingerName(song.getSingerName());
            }
            if (s.getShareFromId() != null){
                List<Share> shareList1 = new ArrayList<>();
                shareList1.add(shareMapper.selectShareByPK_q(s.getShareFromId()));
                s.setShareList(shareList1);
                for (Share s1: s.getShareList()) {
                    s1.setShareCommentCount(shareMapper.getShareCommentCount_q(s.getShareFromId()).getShareCommentCount());
                    s1.setShareForwardCount(shareMapper.getShareForwardCount_q(s.getShareFromId()).getShareForwardCount());
                    if (s1.getSongId() != null){
                        Song song = songMapper.selectSingerByPK_q(s1.getSongId());
                        s1.setSongName(song.getSongName());
                        s1.setSongUrl(song.getSongUrl());
                        s1.setSongPicUrl(song.getSongPicUrl());
                        s1.setSingerName(song.getSingerName());
                    }
                }
            }


        }
        return shareList;
    }

    @Override
    public List<ShareComment> selectByShareId(Integer shareId) {
        List<ShareComment> shareCommentList = shareCommentMapper.selectByShareId(shareId);
        for (ShareComment s : shareCommentList) {
            if (s.getScToId() != null){
                s.setShareCommentList(shareCommentMapper.selectByShareId(s.getScToId()));
            }
        }
        return shareCommentList;
    }

    @Override
    public int updateShareLikesByPK(Integer shareId) {
        return shareMapper.updateShareLikesByPK_q(shareId);
    }


    @Override
    //    徐东方
    public List<Share> getEventCount(Integer userId){
        return shareMapper.getEventCount(userId);
    }
//    徐东方


    @Override
    public Integer insertShareComment(ShareComment shareComment) {
        return shareCommentMapper.insertSelective(shareComment);
    }



}
