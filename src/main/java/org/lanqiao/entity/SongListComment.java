package org.lanqiao.entity;

import org.apache.catalina.User;
import java.util.Date;

public class SongListComment {
    private Integer songlcId;

    private Integer songlistId;

    private Integer userId;

    private String songlcText;

    private Integer songlcLikes;

    private Integer songlcToId;

    private Date songlcTime;
    //用户和评论是一对多，所以在多的一方添加一的一个实体
    private Users user;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Integer getSonglcId() {
        return songlcId;
    }

    public void setSonglcId(Integer songlcId) {
        this.songlcId = songlcId;
    }

    public Integer getSonglistId() {
        return songlistId;
    }

    public void setSonglistId(Integer songlistId) {
        this.songlistId = songlistId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSonglcText() {
        return songlcText;
    }

    public void setSonglcText(String songlcText) {
        this.songlcText = songlcText == null ? null : songlcText.trim();
    }

    public Integer getSonglcLikes() {
        return songlcLikes;
    }

    public void setSonglcLikes(Integer songlcLikes) {
        this.songlcLikes = songlcLikes;
    }

    public Integer getSonglcToId() {
        return songlcToId;
    }

    public void setSonglcToId(Integer songlcToId) {
        this.songlcToId = songlcToId;
    }

    public Date getSonglcTime() {
        return songlcTime;
    }

    public void setSonglcTime(Date songlcTime) {
        this.songlcTime = songlcTime;
    }
}