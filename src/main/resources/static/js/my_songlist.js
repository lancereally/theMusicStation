$(function () {
    var ss = new Vue({
        el: "#songVue",
        data: {
            songSet: []
        },
        methods: {
            getSongSet: function () {
                ss.songSet = [];
                $.ajax({
                    url: "/MyMusic/songlist/songshow",
                    type: "post",
                    data: {
                        songListId: 1
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                ss.songSet.push({
                                    songName: data[i].songName,
                                    songDuration: data[i].songDuration,
                                    singerName: data[i].singerName,
                                    albumName: data[i].album.albumName
                                });
                            }
                        } else {
                            alert("表中无记录");
                        }
                    }
                });
            }
        }
    });
    var sinfo = new Vue({
        el: "#songInfo",
        data: {
            songCount: "",
            songPlayCount: ""
        },
        methods: {
            getSongCount: function () {
                sinfo.songCount;
                $.ajax({
                    url: "/MyMusic/songlist/countshow",
                    type: "post",
                    data: {songListId: 1},
                    dataType: "json",
                    success: function (data) {
                        songCount = data;
                    }
                })
            },
            getSongPlayCount: function () {
                sinfo.songPlayCount;
                $.ajax({
                    url: "/MyMusic/songlist/playcountshow",
                    type: "post",
                    data: {songListId: 1},
                    dataType: "json",
                    success: function (data) {
                        songPlayCount = data;
                    }
                })
            }
        }
    });
    var comment = new Vue({
        el: "#songComment",
        data: {
            commentList: []
        },
        methods: {
            getComment: function () {
                comment.commentList = [];
                $.ajax({
                    url: "/MyMusic/songlist/showComment",
                    type: "post",
                    data: {
                        songListId: 1
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data.length > 0) {
                            for (var i = 0; i < data.length; i++) {
                                comment.commentList.push({
                                    songlcText: data[i].songlcText,
                                    songlcTime: data[i].songlcTime,
                                    songlcLikes: data[i].songlcLikes,
                                    userName: data[i].user.userName,
                                    userHeadUrl: data[i].user.userHeadUrl
                                });
                            }
                        } else {
                            alert("表中无记录");
                        }
                    }
                })
            }
        }
    });
    var songList = new Vue({
        el: "#listInfo",
        data: {
            songlistName: "",
            songlistCreateTime: "",
            songlistPicUrl: "",
            userName: "",
            userHeadUrl: ""
            // listMsg:[]
        },
        methods: {
            getListInfo: function () {
                // songList.listMsg=[];
                $.ajax({
                    url: "/MyMusic/showSonglistInfo",
                    type: "post",
                    data: {
                        songListId: 1,
                        userId: 5
                    },
                    dataType: "json",
                    success: function (data) {
                        songList.songlistName=data.songlistName;
                        songList.songlistCreateTime=data.songlistCreateTime;
                        songList.songlistPicUrl=data.songlistPicUrl;
                        songList.userName=data.usersSet[0].userName;
                        songList.userHeadUrl=data.usersSet[0].userHeadUrl
                    }
                });
            }
        }
    });

    ss.getSongSet();
    sinfo.getSongCount();
    sinfo.getSongPlayCount();
    comment.getComment();
    songList.getListInfo();
});