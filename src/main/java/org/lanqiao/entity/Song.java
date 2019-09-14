package org.lanqiao.entity;

import java.util.Date;

public class Song {
    private Integer songId;

    private String songName;

    private String songLyric;

    private String songDescription;

    private String songUrl;

    private String songDuration;

    private Integer songDownload;

    private Integer songCommetCount;

    private Integer songPlayTimes;

    private Date songCreateDate;

    private Integer songStatus;

    private Integer songKeepNum;

    private Integer albumId;

    private String songPicUrl;

    private Integer singerId;

    private String singerName;
    //专辑歌曲是一对多，所以在多的一方添加一的一个实体
    private Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName == null ? null : songName.trim();
    }

    public String getSongLyric() {
        return songLyric;
    }

    public void setSongLyric(String songLyric) {
        this.songLyric = songLyric == null ? null : songLyric.trim();
    }

    public String getSongDescription() {
        return songDescription;
    }

    public void setSongDescription(String songDescription) {
        this.songDescription = songDescription == null ? null : songDescription.trim();
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl == null ? null : songUrl.trim();
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration == null ? null : songDuration.trim();
    }

    public Integer getSongDownload() {
        return songDownload;
    }

    public void setSongDownload(Integer songDownload) {
        this.songDownload = songDownload;
    }

    public Integer getSongCommetCount() {
        return songCommetCount;
    }

    public void setSongCommetCount(Integer songCommetCount) {
        this.songCommetCount = songCommetCount;
    }

    public Integer getSongPlayTimes() {
        return songPlayTimes;
    }

    public void setSongPlayTimes(Integer songPlayTimes) {
        this.songPlayTimes = songPlayTimes;
    }

    public Date getSongCreateDate() {
        return songCreateDate;
    }

    public void setSongCreateDate(Date songCreateDate) {
        this.songCreateDate = songCreateDate;
    }

    public Integer getSongStatus() {
        return songStatus;
    }

    public void setSongStatus(Integer songStatus) {
        this.songStatus = songStatus;
    }

    public Integer getSongKeepNum() {
        return songKeepNum;
    }

    public void setSongKeepNum(Integer songKeepNum) {
        this.songKeepNum = songKeepNum;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getSongPicUrl() {
        return songPicUrl;
    }

    public void setSongPicUrl(String songPicUrl) {
        this.songPicUrl = songPicUrl == null ? null : songPicUrl.trim();
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }
}