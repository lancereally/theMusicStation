package org.lanqiao.entity;

import java.util.Date;
import java.util.Set;

public class SongList {
        private Integer songlistId;

    private String songlistName;

    private String songlistDescription;

    private String songlistTag;

    private Integer songlistCount;

    private Date songlistCreateTime;

    private Integer songlistCommetNum;

    private Integer songlistKeepNum;

    private String songlistPicUrl;

    private Set<Users> usersSet;

    public Set<Users> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(Set<Users> usersSet) {
        this.usersSet = usersSet;
    }

    public Integer getSonglistId() {
        return songlistId;
    }

    public void setSonglistId(Integer songlistId) {
        this.songlistId = songlistId;
    }

    public String getSonglistName() {
        return songlistName;
    }

    public void setSonglistName(String songlistName) {
        this.songlistName = songlistName == null ? null : songlistName.trim();
    }

    public String getSonglistDescription() {
        return songlistDescription;
    }

    public void setSonglistDescription(String songlistDescription) {
        this.songlistDescription = songlistDescription == null ? null : songlistDescription.trim();
    }

    public String getSonglistTag() {
        return songlistTag;
    }

    public void setSonglistTag(String songlistTag) {
        this.songlistTag = songlistTag == null ? null : songlistTag.trim();
    }

    public Integer getSonglistCount() {
        return songlistCount;
    }

    public void setSonglistCount(Integer songlistCount) {
        this.songlistCount = songlistCount;
    }

    public Date getSonglistCreateTime() {
        return songlistCreateTime;
    }

    public void setSonglistCreateTime(Date songlistCreateTime) {
        this.songlistCreateTime = songlistCreateTime;
    }

    public Integer getSonglistCommetNum() {
        return songlistCommetNum;
    }

    public void setSonglistCommetNum(Integer songlistCommetNum) {
        this.songlistCommetNum = songlistCommetNum;
    }

    public Integer getSonglistKeepNum() {
        return songlistKeepNum;
    }

    public void setSonglistKeepNum(Integer songlistKeepNum) {
        this.songlistKeepNum = songlistKeepNum;
    }

    public String getSonglistPicUrl() {
        return songlistPicUrl;
    }

    public void setSonglistPicUrl(String songlistPicUrl) {
        this.songlistPicUrl = songlistPicUrl == null ? null : songlistPicUrl.trim();
    }
}