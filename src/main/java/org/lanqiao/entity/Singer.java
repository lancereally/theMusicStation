package org.lanqiao.entity;

public class Singer {
    private Integer singerId;

    private String singerName;

    private Integer userId;

    private String singerDescription;

    private String singerPicUrl;

    //用户账户的用户名
    private String userName;

    //用户账户的头像地址
    private String userHeadUrl;

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

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName == null ? null : singerName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSingerDescription() {
        return singerDescription;
    }

    public void setSingerDescription(String singerDescription) {
        this.singerDescription = singerDescription == null ? null : singerDescription.trim();
    }

    public String getSingerPicUrl() {
        return singerPicUrl;
    }

    public void setSingerPicUrl(String singerPicUrl) {
        this.singerPicUrl = singerPicUrl == null ? null : singerPicUrl.trim();
    }
}