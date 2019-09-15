package org.lanqiao.entity;

import java.util.Date;
import java.util.List;

public class ShareComment {
    private Integer scId;

    private Integer shareId;

    private Integer userId;

    private String scText;

    private Integer scLikes;

    private Integer scToId;

    private Date scTime;

    private String userName;

    private String userHeadUrl;

    private List<ShareComment> shareCommentList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHeadUrl() {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl) {
        this.userHeadUrl = userHeadUrl;
    }

    public List<ShareComment> getShareCommentList() {
        return shareCommentList;
    }

    public void setShareCommentList(List<ShareComment> shareCommentList) {
        this.shareCommentList = shareCommentList;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getScText() {
        return scText;
    }

    public void setScText(String scText) {
        this.scText = scText == null ? null : scText.trim();
    }

    public Integer getScLikes() {
        return scLikes;
    }

    public void setScLikes(Integer scLikes) {
        this.scLikes = scLikes;
    }

    public Integer getScToId() {
        return scToId;
    }

    public void setScToId(Integer scToId) {
        this.scToId = scToId;
    }

    public Date getScTime() {
        return scTime;
    }

    public void setScTime(Date scTime) {
        this.scTime = scTime;
    }
}