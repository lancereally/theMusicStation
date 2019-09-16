package org.lanqiao.entity;

import java.util.Date;

public class AlbumComment {
    private Integer albumcId;

    private Integer albumId;

    private Integer userId;

    private String albumcText;

    private Integer albumcLikes;

    private Integer albumcToId;

    private Date albumcTime;

    public Integer getAlbumcId() {
        return albumcId;
    }

    public void setAlbumcId(Integer albumcId) {
        this.albumcId = albumcId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAlbumcText() {
        return albumcText;
    }

    public void setAlbumcText(String albumcText) {
        this.albumcText = albumcText == null ? null : albumcText.trim();
    }

    public Integer getAlbumcLikes() {
        return albumcLikes;
    }

    public void setAlbumcLikes(Integer albumcLikes) {
        this.albumcLikes = albumcLikes;
    }

    public Integer getAlbumcToId() {
        return albumcToId;
    }

    public void setAlbumcToId(Integer albumcToId) {
        this.albumcToId = albumcToId;
    }

    public Date getAlbumcTime() {
        return albumcTime;
    }

    public void setAlbumcTime(Date albumcTime) {
        this.albumcTime = albumcTime;
    }
}