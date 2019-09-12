package org.lanqiao.entity;

import java.util.Date;

public class RidioShow {
    private Integer showId;

    private Integer radioId;

    private String showName;

    private String showCoverUrl;

    private String showDescription;

    private String showUrl;

    private Integer showDuration;

    private Integer showLikes;

    private Integer showComment;

    private Integer showPlayTimes;

    private Date showCreateDate;

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getRadioId() {
        return radioId;
    }

    public void setRadioId(Integer radioId) {
        this.radioId = radioId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public String getShowCoverUrl() {
        return showCoverUrl;
    }

    public void setShowCoverUrl(String showCoverUrl) {
        this.showCoverUrl = showCoverUrl == null ? null : showCoverUrl.trim();
    }

    public String getShowDescription() {
        return showDescription;
    }

    public void setShowDescription(String showDescription) {
        this.showDescription = showDescription == null ? null : showDescription.trim();
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl == null ? null : showUrl.trim();
    }

    public Integer getShowDuration() {
        return showDuration;
    }

    public void setShowDuration(Integer showDuration) {
        this.showDuration = showDuration;
    }

    public Integer getShowLikes() {
        return showLikes;
    }

    public void setShowLikes(Integer showLikes) {
        this.showLikes = showLikes;
    }

    public Integer getShowComment() {
        return showComment;
    }

    public void setShowComment(Integer showComment) {
        this.showComment = showComment;
    }

    public Integer getShowPlayTimes() {
        return showPlayTimes;
    }

    public void setShowPlayTimes(Integer showPlayTimes) {
        this.showPlayTimes = showPlayTimes;
    }

    public Date getShowCreateDate() {
        return showCreateDate;
    }

    public void setShowCreateDate(Date showCreateDate) {
        this.showCreateDate = showCreateDate;
    }
}