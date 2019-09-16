package org.lanqiao.entity;

import java.util.Date;

public class SongListComment {
    private Integer songlcId;

    private Integer songlistId;

    private Integer userId;

    private String songlcText;

    private Integer songlcLikes;

    private Integer songlcToId;

    private Date songlcTime;

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