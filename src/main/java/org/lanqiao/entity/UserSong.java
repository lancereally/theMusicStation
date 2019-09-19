package org.lanqiao.entity;

public class UserSong {
    private Integer usId;

    private Integer userId;

    private Integer songId;

    private Integer usLikedState;

    private Integer usPlayTimes;

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
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

    public Integer getUsLikedState() {
        return usLikedState;
    }

    public void setUsLikedState(Integer usLikedState) {
        this.usLikedState = usLikedState;
    }

    public Integer getUsPlayTimes() {
        return usPlayTimes;
    }

    public void setUsPlayTimes(Integer usPlayTimes) {
        this.usPlayTimes = usPlayTimes;
    }
}