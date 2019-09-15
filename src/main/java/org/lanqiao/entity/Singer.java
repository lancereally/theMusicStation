package org.lanqiao.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

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