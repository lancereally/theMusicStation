package org.lanqiao.entity;

import java.util.Date;

public class Album {
    private Integer albumId;

    private String albumName;

    private String albumDescription;

    private String albumCompany;

    private Integer albumCount;

    private Date albumCreateTime;

    private Integer albumCommetNum;

    private Integer albumKeepNum;

    private String albumPicUrl;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription == null ? null : albumDescription.trim();
    }

    public String getAlbumCompany() {
        return albumCompany;
    }

    public void setAlbumCompany(String albumCompany) {
        this.albumCompany = albumCompany == null ? null : albumCompany.trim();
    }

    public Integer getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }

    public Date getAlbumCreateTime() {
        return albumCreateTime;
    }

    public void setAlbumCreateTime(Date albumCreateTime) {
        this.albumCreateTime = albumCreateTime;
    }

    public Integer getAlbumCommetNum() {
        return albumCommetNum;
    }

    public void setAlbumCommetNum(Integer albumCommetNum) {
        this.albumCommetNum = albumCommetNum;
    }

    public Integer getAlbumKeepNum() {
        return albumKeepNum;
    }

    public void setAlbumKeepNum(Integer albumKeepNum) {
        this.albumKeepNum = albumKeepNum;
    }

    public String getAlbumPicUrl() {
        return albumPicUrl;
    }

    public void setAlbumPicUrl(String albumPicUrl) {
        this.albumPicUrl = albumPicUrl == null ? null : albumPicUrl.trim();
    }
}