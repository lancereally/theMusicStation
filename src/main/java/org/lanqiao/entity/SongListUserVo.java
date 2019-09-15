package org.lanqiao.entity;

public class SongListUserVo {
    private String songlistName;
    private Integer songlistId;
    private int userId;

    public String getSonglistName() {
        return songlistName;
    }

    public void setSonglistName(String songlistName) {
        this.songlistName = songlistName;
    }

    public Integer getSonglistId() {
        return songlistId;
    }

    public void setSonglistId(Integer songlistId) {
        this.songlistId = songlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
