package org.lanqiao.entity;

import java.util.Date;

public class SongComment {
    private Integer songcId;

    private Integer songId;

    private Integer userId;

    private String songcText;

    private Integer songcLikes;

    private Integer songcToId;

    private Date songcTime;

    public Integer getSongcId() {
        return songcId;
    }

    public void setSongcId(Integer songcId) {
        this.songcId = songcId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSongcText() {
        return songcText;
    }

    public void setSongcText(String songcText) {
        this.songcText = songcText == null ? null : songcText.trim();
    }

    public Integer getSongcLikes() {
        return songcLikes;
    }

    public void setSongcLikes(Integer songcLikes) {
        this.songcLikes = songcLikes;
    }

    public Integer getSongcToId() {
        return songcToId;
    }

    public void setSongcToId(Integer songcToId) {
        this.songcToId = songcToId;
    }

    public Date getSongcTime() {
        return songcTime;
    }

    public void setSongcTime(Date songcTime) {
        this.songcTime = songcTime;
    }
}