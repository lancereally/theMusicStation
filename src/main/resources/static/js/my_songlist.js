$(function () {
    //获取url值
    var url = location.search,
        songListId = {};
    //如果url有id
    if(url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i++) {
            songListId[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
        }

    }
    //
    // console.log('传过来的参数是:', songListId.songListId);
    // alert( songListId.songListId);
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
                        songListId: songListId.songListId
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
                            // alert("表中无记录");
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
                    data: {songListId: songListId.songListId},
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
                    data: {songListId: songListId.songListId},
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
            commentList: [],
            userHeadUrl1:""
        },
        methods: {
            getComment: function () {
                comment.commentList = [];
                $.ajax({
                    url: "/MyMusic/songlist/showComment",
                    type: "post",
                    data: {
                        songListId: songListId.songListId
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
                            // alert("表中无记录");
                        }
                    }
                })
            },
            getPic:function () {
                $.ajax({
                    url:"/MyMusic/showSonglistInfo",
                    type:"post",
                    data:{
                        songListId: songListId.songListId,
                        userId:5
                    },
                    dataType:"json",
                    success:function (data) {
                        comment.userHeadUrl1=data.usersSet[0].userHeadUrl;
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
                        songListId: songListId.songListId,
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
    comment.getPic();
    songList.getListInfo();
    $("#msg_send").click(function () {
       $.ajax({
           url:"/MyMusic/songlist/insert",
           type:"post",
           data:{
               songlistId: songListId.songListId,
               songlcText:$("textarea[class='msg_info']").val(),
               userId:5
           },
           dataType:"json",
           success:function (data) {
               if(data==1){
                   layui.use('layer', function () {
                       var layer = layui.layer;
                       layer.msg('评论成功！');
                   });
                   setTimeout("window.location.reload()","1000");
               }
           }
       })
    });
});