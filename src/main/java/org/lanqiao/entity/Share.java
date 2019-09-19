package org.lanqiao.entity;

import java.util.Date;
import java.util.List;

public class Share {
    private Integer shareId;

    private String userName;

    private String userHeadUrl;

    private Integer userVipState;

    private Integer userId;/*用户名*/  /*用户头像*/  /*动态数量*/
    /*关注数量*/ /*粉丝数量*/

    private Integer songId;/*音乐名*/  /*音乐地址*/  /*歌手*/

    private String songName;

    private String songUrl;

    private String singerName;

    private String shareText;

    private String shareTitle;/*视频标题*/

    private String shareAnnexUrl;/*视频地址*/

    private String shareLocation;/*定位*/

    private Integer shareLikes;/*点赞数*/

    private Integer shareFromId;

    private Date shareTime;/*发表时间*/

    private Integer shareVideoTimes;/*视频时长*/

    private Integer shareCommentCount;/*准发数量*/

    private Integer shareForwardCount;/*评论总数*/

    private List<Share> shareList;

    public Integer getUserVipState() {
        return userVipState;
    }

    public void setUserVipState(Integer userVipState) {
        this.userVipState = userVipState;
    }

    public List<Share> getShareList() {
        return shareList;
    }

    public void setShareList(List<Share> shareList) {
        this.shareList = shareList;
    }

    public Integer getShareCommentCount() {
        return shareCommentCount;
    }

    public void setShareCommentCount(Integer shareCommentCount) {
        this.shareCommentCount = shareCommentCount;
    }

    public Integer getShareForwardCount() {
        return shareForwardCount;
    }

    public void setShareForwardCount(Integer shareForwardCount) {
        this.shareForwardCount = shareForwardCount;
    }

    @Override
    public String toString() {
        return "Share{" +
                "shareId=" + shareId +
                ", userName='" + userName + '\'' +
                ", userHeadUrl='" + userHeadUrl + '\'' +
                ", userId=" + userId +
                ", songId=" + songId +
                ", songName='" + songName + '\'' +
                ", songUrl='" + songUrl + '\'' +
                ", singerName='" + singerName + '\'' +
                ", shareText='" + shareText + '\'' +
                ", shareTitle='" + shareTitle + '\'' +
                ", shareAnnexUrl='" + shareAnnexUrl + '\'' +
                ", shareLocation='" + shareLocation + '\'' +
                ", shareLikes=" + shareLikes +
                ", shareFromId=" + shareFromId +
                ", shareTime=" + shareTime +
                ", shareVideoTimes=" + shareVideoTimes +
                '}';
    }

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

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
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

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getShareText() {
        return shareText;
    }

    public void setShareText(String shareText) {
        this.shareText = shareText == null ? null : shareText.trim();
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle == null ? null : shareTitle.trim();
    }

    public String getShareAnnexUrl() {
        return shareAnnexUrl;
    }

    public void setShareAnnexUrl(String shareAnnexUrl) {
        this.shareAnnexUrl = shareAnnexUrl == null ? null : shareAnnexUrl.trim();
    }

    public String getShareLocation() {
        return shareLocation;
    }

    public void setShareLocation(String shareLocation) {
        this.shareLocation = shareLocation == null ? null : shareLocation.trim();
    }

    public Integer getShareLikes() {
        return shareLikes;
    }

    public void setShareLikes(Integer shareLikes) {
        this.shareLikes = shareLikes;
    }

    public Integer getShareFromId() {
        return shareFromId;
    }

    public void setShareFromId(Integer shareFromId) {
        this.shareFromId = shareFromId;
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }

    public Integer getShareVideoTimes() {
        return shareVideoTimes;
    }

    public void setShareVideoTimes(Integer shareVideoTimes) {
        this.shareVideoTimes = shareVideoTimes;
    }
}