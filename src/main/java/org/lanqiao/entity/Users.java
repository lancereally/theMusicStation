package org.lanqiao.entity;

public class Users {
    private Integer userId;

    private String userName;

    private Integer userAccount;

    private String userPassword;

    private String userText;

    private String userSex;

    private String userBirthday;

    private String userLocation;

    private String userHeadUrl;

    private String userRealName;

    private String userEmail;

    private Integer userPhoneActivation;

    private String userPhone;

    private Integer userQq;

    private String userIdCard;

    private Integer userVipState;

<<<<<<< HEAD
    private UserSong userSong;

    private UserSongList userSongList;

    private Song song;

    private Singer singer;

    private SongSongList songSongList;

    private SongList songList;

    private int slCount;

    private SongComment songComment;

    private int userPhoneCode;

    public int getUserPhoneCode() {
        return userPhoneCode;
    }

    public void setUserPhoneCode(int userPhoneCode) {
        this.userPhoneCode = userPhoneCode;
    }

    public SongComment getSongComment() {
        return songComment;
    }

    public void setSongComment(SongComment songComment) {
        this.songComment = songComment;
    }

    public int getSlCount() {
        return slCount;
    }

    public void setSlCount(int slCount) {
        this.slCount = slCount;
    }

    public SongList getSongList() {
        return songList;
    }

    public void setSongList(SongList songList) {
        this.songList = songList;
    }

    public SongSongList getSongSongList() {
        return songSongList;
    }

    public void setSongSongList(SongSongList songSongList) {
        this.songSongList = songSongList;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public UserSongList getUserSongList() {
        return userSongList;
    }

    public void setUserSongList(UserSongList userSongList) {
        this.userSongList = userSongList;
    }

    public UserSong getUserSong() {
        return userSong;
    }

    public void setUserSong(UserSong userSong) {
        this.userSong = userSong;
    }

    //用户粉丝关注关系表
    private Integer useraId;
    private Integer userbId;

    public Integer getUseraId() {
        return useraId;
    }

    public void setUseraId(Integer userAId) {
        this.useraId = userAId;
    }

    public Integer getUserbId() {
        return userbId;
    }

    public void setUserbId(Integer userBId) {
        this.userbId = userBId;
=======
    //粉丝数
    private Integer fans;

    //关注数
    private Integer attention;

    //动态数量
    private Integer shareCount;

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
>>>>>>> 8d37e308c82a9b20ddb6ac311c6acc5b46a4e9c6
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Integer userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText == null ? null : userText.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday == null ? null : userBirthday.trim();
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation == null ? null : userLocation.trim();
    }

    public String getUserHeadUrl() {
        return userHeadUrl;
    }

    public void setUserHeadUrl(String userHeadUrl) {
        this.userHeadUrl = userHeadUrl == null ? null : userHeadUrl.trim();
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName == null ? null : userRealName.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getUserPhoneActivation() {
        return userPhoneActivation;
    }

    public void setUserPhoneActivation(Integer userPhoneActivation) {
        this.userPhoneActivation = userPhoneActivation;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserQq() {
        return userQq;
    }

    public void setUserQq(Integer userQq) {
        this.userQq = userQq;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard == null ? null : userIdCard.trim();
    }

    public Integer getUserVipState() {
        return userVipState;
    }

    public void setUserVipState(Integer userVipState) {
        this.userVipState = userVipState;
    }
}