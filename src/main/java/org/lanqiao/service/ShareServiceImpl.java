package org.lanqiao.service;

import org.lanqiao.entity.Share;
import org.lanqiao.entity.Song;
import org.lanqiao.mapper.ShareMapper;
import org.lanqiao.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShareServiceImpl implements ShareService{

    @Autowired
    ShareMapper shareMapper;

    @Autowired
    SongMapper songMapper;

    @Override
    public List<Share> getAllShare() {
        List<Share> shareList = shareMapper.getAllShare_q();
        System.out.println("n");
        for (Share s: shareList) {
            s.setShareCommentCount(shareMapper.getShareCommentCount_q(s.getShareId()).getShareCommentCount());
            s.setShareForwardCount(shareMapper.getShareForwardCount_q(s.getShareId()).getShareForwardCount());
            if (s.getSongId() != null){
                Song song = songMapper.selectSingerByPK_q(s.getSongId());
                s.setSongName(song.getSongName());
                s.setSongUrl(song.getSongUrl());
                s.setSingerName(song.getSingerName());
            }
            if (s.getShareFromId() != null){
                List<Share> shareList1 = new ArrayList<>();
                shareList1.add(shareMapper.selectShareByPK_q(s.getShareFromId()));
                s.setShareList(shareList1);
                for (Share s1: s.getShareList()) {
                    s1.setShareCommentCount(shareMapper.getShareCommentCount_q(s.getShareId()).getShareCommentCount());
                    s1.setShareForwardCount(shareMapper.getShareForwardCount_q(s.getShareId()).getShareForwardCount());
                    if (s1.getSongId() != null){
                        Song song = songMapper.selectSingerByPK_q(s1.getSongId());
                        s1.setSongName(song.getSongName());
                        s1.setSongUrl(song.getSongUrl());
                        s1.setSingerName(song.getSingerName());
                    }
                }


            }


        }
        return shareList;
    }
}
