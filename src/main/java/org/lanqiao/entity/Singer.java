package org.lanqiao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;


import java.util.Set;
@SolrDocument(solrCoreName = "singers")
public class Singer {
    @Id
    @Indexed
    private Integer singerId;

    @Indexed
    private String singerName;

    private Integer userId;

    @Indexed
    private String singerDescription;

    @Indexed
    private String singerPicUrl;
    //一对多关系。在多的一方添加一的set
    private Set<Album> albumSet;
    //偷懒操作歌手的专辑数
//    private  Integer albumCount;
    //用户账户的用户名
    private String userName;

    private Integer userVipState;

    //用户账户的头像地址
    private String userHeadUrl;

    //歌手的专辑数get set
//    public Integer getAlbumCount() {
//        return albumCount;
//    }
//
//    public void setAlbumCount(Integer albumCount) {
//        this.albumCount = albumCount;
//    }


    public Integer getUserVipState() {
        return userVipState;
    }

    public void setUserVipState(Integer userVipState) {
        this.userVipState = userVipState;
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

    public Set<Album> getAlbumSet() {
        return albumSet;
    }

    public void setAlbumSet(Set<Album> albumSet) {
        this.albumSet = albumSet;
    }
}