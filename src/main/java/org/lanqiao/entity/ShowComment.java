package org.lanqiao.entity;

import java.util.Date;

public class ShowComment {
    private Integer showcId;

    private Integer showId;

    private Integer userId;

    private String showcText;

    private Integer showcLikes;

    private Integer showcToId;

    private Date showcTime;

    public Integer getShowcId() {
        return showcId;
    }

    public void setShowcId(Integer showcId) {
        this.showcId = showcId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShowcText() {
        return showcText;
    }

    public void setShowcText(String showcText) {
        this.showcText = showcText == null ? null : showcText.trim();
    }

    public Integer getShowcLikes() {
        return showcLikes;
    }

    public void setShowcLikes(Integer showcLikes) {
        this.showcLikes = showcLikes;
    }

    public Integer getShowcToId() {
        return showcToId;
    }

    public void setShowcToId(Integer showcToId) {
        this.showcToId = showcToId;
    }

    public Date getShowcTime() {
        return showcTime;
    }

    public void setShowcTime(Date showcTime) {
        this.showcTime = showcTime;
    }
}